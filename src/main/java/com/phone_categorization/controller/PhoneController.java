package com.phone_categorization.controller;

import com.phone_categorization.entity.Customer;
import com.phone_categorization.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class PhoneController
{
    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping(value = "phones", method = RequestMethod.GET)
    public List<Customer> info()
    {
        return customerService.getAllCustomers();
    }
}
