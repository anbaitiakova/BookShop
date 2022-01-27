package com.serveeer.controllers;

import com.serveeer.domain.Customer;
import com.serveeer.domain.Role;
import com.serveeer.service.CustomerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private final CustomerService customerService;

    public UserController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", customerService.findAll());

        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{customer}")
    public String userEditForm(@PathVariable Customer customer, Model model){
        model.addAttribute("user", customer);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(@RequestParam Map<String, String> form,
            @RequestParam("userId") Customer customer){
        customerService.saveCustomer(customer, form);
        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal Customer customer) {
        model.addAttribute("username", customer.getUsername());
        model.addAttribute("email", customer.getEmail());

        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal Customer customer,
            @RequestParam String email,
            @RequestParam String customer_password
    ) {
        customerService.updateProfile(customer, customer_password, email);

        return "redirect:/user/profile";
    }
}
