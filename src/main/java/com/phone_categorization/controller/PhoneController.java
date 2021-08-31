package com.phone_categorization.controller;

import com.phone_categorization.entity.PhoneCategory;
import com.phone_categorization.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    /*
    * Get categorized phone numbers API
    * */
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "phoneList", method = RequestMethod.GET)
    public List<PhoneCategory> readCustomers()
    {
        return customerService.getCategorizedPhoneNmbers();
    }
}
