package com.phone_categorization.services;

import com.phone_categorization.entity.Customer;
import com.phone_categorization.entity.PhoneCategory;

import java.util.List;

public interface CategorizationService
{
    List<PhoneCategory> categorizePhoneNumbers(List<Customer> customers);
}
