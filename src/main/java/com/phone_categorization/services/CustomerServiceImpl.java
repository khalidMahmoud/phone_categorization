package com.phone_categorization.services;

import com.phone_categorization.entity.Customer;
import com.phone_categorization.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }
}
