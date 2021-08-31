package com.phone_categorization.services;

import com.phone_categorization.entity.PhoneCategory;

import java.util.List;

public interface CustomerService
{
    List<PhoneCategory> getCategorizedPhoneNmbers();
}
