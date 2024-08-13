package com.codegym.thi_thuc_hanh.controller;

import com.codegym.thi_thuc_hanh.model.Orders;
import com.codegym.thi_thuc_hanh.service.IOrderService;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping
    public String showList(
            Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("orderDate").descending());
        Page<Orders> orders = orderService.findAll(pageable);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Orders order : orders) {
            String formattedDate = order.getOrderDate().format(formatter);
            order.setFormattedDate(formattedDate);
        }

        model.addAttribute("orders", orders);
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Integer orderId,
                            Model model){
        Optional<Orders> order = orderService.findOrderById(orderId);
        Orders order1 =order.get();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            String formattedDate = order1.getOrderDate().format(formatter);
            order1.setFormattedDate(formattedDate);

        model.addAttribute("order",order1);
        return "edit";
    }

    @PostMapping("/edit")
    public String editOrdor(@ModelAttribute Orders orders,
                            RedirectAttributes redirectAttributes){
        orderService.updateOrder(orders);
        return "redirect:/order";
    }
}
