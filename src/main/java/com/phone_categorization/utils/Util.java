package com.phone_categorization.utils;

import java.util.HashMap;
import java.util.Map;

public class Util
{
    /*
    * Put countries codes in map
    * key => code
    * value => country name
    * */
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

    /*
    * Substring phone number to get code
    * */
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

    /*
    * Delete code brackets
    * */
    public static String deleteBrackets(String phone)
    {
        if (phone.contains("(") && phone.contains(")"))
            return phone.substring(phone.indexOf("(") + 1, phone.indexOf(")"));
        else
            return phone;
    }

    /*
    * Delete code from the full phone number
    * */
    public static String deletePhoneCode(String phone)
    {
        return phone.substring(phone.indexOf(" ")).trim();
    }
}
