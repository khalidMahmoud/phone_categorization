package com.phone_categorization.services;

import com.phone_categorization.entity.Customer;
import com.phone_categorization.entity.PhoneCategory;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;


class CategorizationServiceImplTest
{
    CategorizationServiceImpl categorizationService= new CategorizationServiceImpl();

    @DisplayName("Test Categorization and validation")
    @Test
    void categorizePhoneNumbers()
    {
        List<Customer> customers = new ArrayList<>();
        List<PhoneCategory> phoneCategories = new ArrayList<>();

        customers.add(new Customer(0,"Walid Hammadi","(212) 6007989253"));
        customers.add(new Customer(0,"Edunildo Gomes Alberto","(258) 847651504"));
        phoneCategories.add(new PhoneCategory("(212) 6007989253","Morocco","(212)","6007989253","Valid"));
        phoneCategories.add(new PhoneCategory("(258) 847651504","Mozambique","(258)","847651504","Valid"));

        assertThat(categorizationService.categorizePhoneNumbers(customers).get(0).getPhone(), is(phoneCategories.get(0).getPhone()));
        assertThat(categorizationService.categorizePhoneNumbers(customers).get(0).getCountry(), is(phoneCategories.get(0).getCountry()));
        assertThat(categorizationService.categorizePhoneNumbers(customers).get(0).getCode(), is(phoneCategories.get(0).getCode()));
        assertThat(categorizationService.categorizePhoneNumbers(customers).get(0).getNumber(), is(phoneCategories.get(0).getNumber()));
        assertThat(categorizationService.categorizePhoneNumbers(customers).get(0).getPhone(), is(phoneCategories.get(0).getPhone()));
        assertThat(categorizationService.categorizePhoneNumbers(customers), not(IsEmptyCollection.empty()));

        assertThat(categorizationService.categorizePhoneNumbers(customers).get(1).getPhone(), is(phoneCategories.get(1).getPhone()));
        assertThat(categorizationService.categorizePhoneNumbers(customers).get(1).getCountry(), is(phoneCategories.get(1).getCountry()));
        assertThat(categorizationService.categorizePhoneNumbers(customers).get(1).getCode(), is(phoneCategories.get(1).getCode()));
        assertThat(categorizationService.categorizePhoneNumbers(customers).get(1).getNumber(), is(phoneCategories.get(1).getNumber()));
        assertThat(categorizationService.categorizePhoneNumbers(customers).get(1).getPhone(), is(phoneCategories.get(1).getPhone()));
        assertThat(categorizationService.categorizePhoneNumbers(customers), not(IsEmptyCollection.empty()));
    }
}
