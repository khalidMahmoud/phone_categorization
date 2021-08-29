package com.phone_categorization.services;

import com.phone_categorization.entity.Customer;
import com.phone_categorization.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CategorizationServiceImpl categorizationService;

    @Override
    public List<String> getAllCustomers()
    {
        List<Customer> customers = customerRepository.findAll();

        categorizationService.categorizePhoneNumbers(customers);
        List<String> phoneNumbers = customers.stream().map(customer -> customer.getPhone()).collect(Collectors.toList());
        Pattern pattern = Pattern.compile("\\(237\\)\\ ?[2368]\\d{7,8}$");

        List<String> matching = phoneNumbers.stream()
                .filter(pattern.asPredicate())
                .collect(Collectors.toList());
        return matching;
    }
}
