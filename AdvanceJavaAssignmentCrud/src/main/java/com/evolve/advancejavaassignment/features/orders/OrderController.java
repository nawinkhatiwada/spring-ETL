package com.evolve.advancejavaassignment.features.orders;

import com.evolve.advancejavaassignment.data.dto.SkuDto;
import com.evolve.advancejavaassignment.data.entity.Order;
import com.evolve.advancejavaassignment.data.entity.Sku;
import com.evolve.advancejavaassignment.features.skus.SkuService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final SkuService skuService;

    public OrderController(OrderService orderService, SkuService skuService) {
        this.orderService = orderService;
        this.skuService = skuService;
    }

    @PostMapping("order/create")
    public String getSkuList(Model model) {
        Order order = new Order();
        order.setOrderedSkus(Set.copyOf(skuService.getAllSku()));
        model.addAttribute("orderDto", order);
        return "order/create";
    }


    @PostMapping(value = "/order/new",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE}
    )
    @Transactional
    public String placeAnOrder(ArrayList<Order> orderedSkus) {
        System.out.println("Ordered SKU----> " + orderedSkus);
        return "order/order_success";
//        Object o = session.getAttribute("userId");
//        System.out.println("o---> " + o);
    }
}
