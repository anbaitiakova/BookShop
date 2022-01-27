package com.serveeer.controllers;

import com.serveeer.domain.Customer;
import com.serveeer.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {
    private final CustomerService customerService;

    public RegistrationController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addCustomer(@Valid Customer customer, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);

            model.mergeAttributes(errors);

            return "registration";
        }
        if(!customerService.addCustomer(customer))
        {
            model.addAttribute("message", "Customer with this email already exists!");
            return "registration";
        }
        return "redirect:/login";
    }
}
