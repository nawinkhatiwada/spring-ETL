package com.evolve.advancejavaassignment.features.skus;

import com.evolve.advancejavaassignment.data.dto.SkuDto;
import com.evolve.advancejavaassignment.data.entity.Sku;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class SkusController {
    private final SkuService skuService;

    public SkusController(SkuService skuService) {
        this.skuService = skuService;
    }

    @PostMapping("/new")
    public String addSku(@ModelAttribute("sku") SkuDto skuDto, Model model) {
        System.out.println("SKU" + skuDto);
        try {
            Optional<Sku> oldSku = skuService.findSkuByName(skuDto.getName());
            if (oldSku.isPresent()) {
                model.addAttribute("message", "Can't add same sku twice");
            } else {
                skuService.addNewSku(skuDto);
                model.addAttribute("message", "Sku Added successfully.");
            }
        } catch (Exception error) {
            error.printStackTrace();
            model.addAttribute("message", error.getMessage());
        }
        return  "/sku/create";
    }
}
