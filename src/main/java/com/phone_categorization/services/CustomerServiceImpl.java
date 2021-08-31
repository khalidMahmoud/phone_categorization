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
    public List<PhoneCategory> getCategorizedPhoneNmbers()
    {
        /**
         *call db and get list of customers
         */
        List<Customer> customers = customerRepository.findAll();

        /**
         * Categorize these customers phone numbers
         * which country and valid or not valid
         */
        return categorizationService.categorizePhoneNumbers(customers);
    }
}
