package com.phone_categorization.services;

import com.phone_categorization.entity.Customer;
import com.phone_categorization.entity.PhoneCategory;
import com.phone_categorization.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CategorizationServiceImpl categorizationService;

    @Override
    public List<PhoneCategory> getAllCustomers()
    {
        List<Customer> customers = customerRepository.findAll();

        return categorizationService.categorizePhoneNumbers(customers);
    }
}
