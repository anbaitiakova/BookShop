package com.serveeer.service;

import com.serveeer.domain.Customer;
import com.serveeer.domain.Role;
import com.serveeer.repos.CustomerRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerService implements UserDetailsService {
    private final CustomerRepo customerRepo;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepo customerRepo, PasswordEncoder passwordEncoder) {
        this.customerRepo = customerRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepo.findByUsername(username);
        if(customer == null)
        {
            throw new UsernameNotFoundException("Customer not found!");
        }
        return customer;
    }

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    public boolean addCustomer(Customer customer){
        //Customer custFromDB = customerRepo.findByUsername(customer.getUsername());
        Customer custFromDB = customerRepo.findCustomerByEmail(customer.getEmail());
        if(custFromDB != null)
        {
            return false;
        }
        customer.setRoles(Collections.singleton(Role.USER));
        customer.setCustomer_password(passwordEncoder.encode(customer.getCustomer_password()));
        customerRepo.save(customer);
        return true;
    }


    public void saveCustomer(Customer customer, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        customer.getRoles().clear();
        for(String key : form.keySet())
        {
            if(roles.contains(key))
            {
                customer.getRoles().add(Role.valueOf(key));
            }
        }
        customerRepo.save(customer);
    }

    public void updateProfile(Customer customer, String password, String email) {
        String userEmail = customer.getEmail();
        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));

        if (isEmailChanged) {
            customer.setEmail(email);
        }

        if (!StringUtils.isEmpty(password)) {
            customer.setCustomer_password(passwordEncoder.encode(password));
        }

        customerRepo.save(customer);

    }
}
