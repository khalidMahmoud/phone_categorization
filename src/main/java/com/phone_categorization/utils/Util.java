package com.phone_categorization.utils;

import java.util.HashMap;
import java.util.Map;

public class Util
{
    public static Map<String, String> prepareCountryCodeMap()
    {
        Map countryCode = new HashMap();
        countryCode.put("237", "Cameroon");
        countryCode.put("251", "Ethiopia");
        countryCode.put("212", "Morocco");
        countryCode.put("258", "Mozambique");
        countryCode.put("256", "Uganda");
        return countryCode;
    }

    public static String getPhoneCode(String phone)
    {
        if (phone.contains("(") && phone.contains(")"))
        {
            return "(" + phone.substring(phone.indexOf("(") + 1, phone.indexOf(")")) + ")";
        } else
        {
            return "";
        }
    }

    public static String deleteBrackets(String phone)
    {
        if (phone.contains("(") && phone.contains(")"))
            return phone.substring(phone.indexOf("(") + 1, phone.indexOf(")"));
        else
            return phone;
    }

    public static String deletePhoneCode(String phone)
    {
        return phone.substring(phone.indexOf(" ")).trim();
    }
}
