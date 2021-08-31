package com.phone_categorization.services;

import com.phone_categorization.entity.Customer;
import com.phone_categorization.entity.PhoneCategory;
import com.phone_categorization.utils.Definations;
import com.phone_categorization.utils.Util;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CategorizationServiceImpl implements CategorizationService
{


    @Override
    public List<PhoneCategory> categorizePhoneNumbers(List<Customer> customers)
    {
        return categorizeCountries(customers);
    }

    /*
    * Categorize and validate phone numbers
    * */
    private List<PhoneCategory> categorizeCountries(List<Customer> customers)
    {
        List<PhoneCategory> phoneCategories = convertCustomerToPhoneCategory(customers);
        if (phoneCategories.size() > 0)
            return categorizeValidAndNotValid(phoneCategories);
        else
            return null;
    }

    /*
    * Convert list of customer objects to phoneCategory object
    * country, phone, code, state and number
    * */
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

    /*
    * Validate phone numbers using regex
    * */
    private List<PhoneCategory> categorizeValidAndNotValid(List<PhoneCategory> phoneCategories)
    {
        List<PhoneCategory> validatedPhoneNumbers = new ArrayList();

        List<PhoneCategory> cameroon = validate(getPhoneCategoryByCode(phoneCategories, Definations.cameroonCode), Definations.cameroonPattern);
        List<PhoneCategory> ethiopia = validate(getPhoneCategoryByCode(phoneCategories, Definations.ethiopiaCode), Definations.ethiopiaPattern);
        List<PhoneCategory> morocco = validate(getPhoneCategoryByCode(phoneCategories, Definations.moroccoCode), Definations.moroccoPattern);
        List<PhoneCategory> mozambique = validate(getPhoneCategoryByCode(phoneCategories, Definations.mozambiqueCode), Definations.mozambiquePattern);
        List<PhoneCategory> uganda = validate(getPhoneCategoryByCode(phoneCategories, Definations.ugandaCode), Definations.ugandaPattern);

        validatedPhoneNumbers.addAll(cameroon);
        validatedPhoneNumbers.addAll(ethiopia);
        validatedPhoneNumbers.addAll(morocco);
        validatedPhoneNumbers.addAll(mozambique);
        validatedPhoneNumbers.addAll(uganda);

        return validatedPhoneNumbers;
    }

    /*
    * Categorize phone number by code
    * */
    private List<PhoneCategory> getPhoneCategoryByCode(List<PhoneCategory> phoneCategories, String code)
    {
        return phoneCategories.stream().filter(element -> element.getCode().equals(code)).
                collect(Collectors.toList());
    }

    /*
    * Validate number if pass the regex pattern or not
    * */
    private List<PhoneCategory> validate(List<PhoneCategory> phoneCategories, String patern)
    {

        for (PhoneCategory phoneCategory : phoneCategories)
        {
            Pattern pattern = Pattern.compile(patern);
            if (pattern.matcher(phoneCategory.getPhone()).matches())
            {
                phoneCategory.setState("Valid");
            } else
            {
                phoneCategory.setState("Not valid");
            }
        }
        return phoneCategories;
    }


}
