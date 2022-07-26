package com.evolve.advancejavaassignment.features.users;

import com.evolve.advancejavaassignment.data.dto.SkuDto;
import com.evolve.advancejavaassignment.data.dto.UserDto;
import com.evolve.advancejavaassignment.data.entity.User;
import com.evolve.advancejavaassignment.errors.UserAlreadyExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/create")
    public String getUserPage(@ModelAttribute UserDto dto, Model model) {
        model.addAttribute("user", dto);
        return "user/create";
    }

    @PostMapping("/sku/create")
    @Transactional
    public String doOnRegisterClicked(@ModelAttribute("user")UserDto userDto, @ModelAttribute("sku") SkuDto skuDto, Model model, HttpSession session) {
        try {
            System.out.println("User Dto" + userDto);
            Optional<User> oldUser = userService.findUserByEmail(userDto.getEmail());
            if (oldUser.isPresent()) {
//                session.setAttribute("userId", oldUser.get().getId());
                model.addAttribute("sku", skuDto);
            } else {
                User newUser = userService.requestUserRegistration(userDto);
//                session.setAttribute("userId", newUser.getId());
                model.addAttribute("sku", skuDto);
            }
            return "/sku/create";
        } catch (Exception error) {
            model.addAttribute("errorMessage", error.getMessage());
            error.printStackTrace();
        }
        return "/user/create";
    }
}
