package com.phone_categorization.services;

import com.phone_categorization.entity.Customer;
import com.phone_categorization.entity.PhoneCategory;
import com.phone_categorization.utils.Util;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategorizationServiceImpl implements CategorizationService
{

    @Override
    public List<PhoneCategory> categorizePhoneNumbers(List<Customer> customers)
    {
        List<PhoneCategory> phoneCategories = new ArrayList<>();
        categorizeCountries(customers);
        return phoneCategories;
    }

    private void categorizeCountries(List<Customer> customers)
    {
        List<PhoneCategory> phoneCategories = convertCustomerToPhoneCategory(customers);


    }

    private List<PhoneCategory> convertCustomerToPhoneCategory(List<Customer> customers)
    {
        Map<String, String> countryCodeMap = Util.prepareCountryCodeMap();

        List<PhoneCategory> phoneCategories = new ArrayList<>();

        for (Customer customer : customers)
        {
            PhoneCategory phoneCategory = new PhoneCategory();
            phoneCategory.setPhone(customer.getPhone());

            phoneCategory.setCode(Util.getPhoneCode(customer.getPhone()));

            phoneCategory.setCountry(countryCodeMap.get(Util.deleteBrackets(phoneCategory.getCode())));

            phoneCategory.setNumber(Util.deletePhoneCode(phoneCategory.getPhone()));

            phoneCategories.add(phoneCategory);
        }
        return phoneCategories;
    }

    private List<PhoneCategory> validate()
    {
        return null;
    }


}
