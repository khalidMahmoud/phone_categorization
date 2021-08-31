package com.phone_categorization.utils;

import com.phone_categorization.services.CategorizationServiceImpl;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

class UtilTest
{
    @Autowired
    private CategorizationServiceImpl categorizationService;

    @Test
    void prepareCountryCodeMap()
    {
        Map<String, String> countryCode = new HashMap<>();
        countryCode.put("237", "Cameroon");
        countryCode.put("251", "Ethiopia");
        countryCode.put("212", "Morocco");
        countryCode.put("258", "Mozambique");
        countryCode.put("256", "Uganda");


        assertThat(Util.prepareCountryCodeMap(), is(countryCode));
        assertThat(Util.prepareCountryCodeMap().size(), is(5));
        assertThat(Util.prepareCountryCodeMap(), IsMapContaining.hasEntry("237", "Cameroon"));
        assertThat(Util.prepareCountryCodeMap(), not(IsMapContaining.hasEntry("2510", "Ethiopia123")));
        assertThat(Util.prepareCountryCodeMap(), IsMapContaining.hasKey("212"));
        assertThat(Util.prepareCountryCodeMap(), IsMapContaining.hasValue("Uganda"));
    }

    /*
     * Testing getPhoneCode method
     * */
    @Test
    void getPhoneCode()
    {
        Assertions.assertEquals(Util.getPhoneCode("(212) 6007989253"), "(212)", "Returned code is not correct");
        Assertions.assertEquals(Util.getPhoneCode("(258) 847651504"), "(258)", "Returned code is not correct");
        Assertions.assertEquals(Util.getPhoneCode("(256) 7503O6263"), "(256)", "Returned code is not correct");
        Assertions.assertEquals(Util.getPhoneCode("(251) 6007989253"), "(251)", "Returned code is not correct");
        Assertions.assertEquals(Util.getPhoneCode("(212) 6007989253"), "(212)", "Returned code is not correct");
    }

    @Test
    void deleteBrackets()
    {
        Assertions.assertEquals(Util.deleteBrackets("(212) 6007989253"), "212", "Returned code is not correct");
        Assertions.assertEquals(Util.deleteBrackets("(258) 847651504"), "258", "Returned code is not correct");
        Assertions.assertEquals(Util.deleteBrackets("(256) 7503O6263"), "256", "Returned code is not correct");
        Assertions.assertEquals(Util.deleteBrackets("(251) 6007989253"), "251", "Returned code is not correct");
        Assertions.assertEquals(Util.deleteBrackets("(212) 6007989253"), "212", "Returned code is not correct");
    }

    @Test
    void deletePhoneCode()
    {
        Assertions.assertEquals(Util.deletePhoneCode("(212) 6007989253"), "6007989253", "Returned number is not correct");
        Assertions.assertEquals(Util.deletePhoneCode("(212) 6007989253"), "6007989253", "Returned number is not correct");
        Assertions.assertEquals(Util.deletePhoneCode("(212) 6007989253"), "6007989253", "Returned number is not correct");
        Assertions.assertEquals(Util.deletePhoneCode("(212) 6007989253"), "6007989253", "Returned number is not correct");
        Assertions.assertEquals(Util.deletePhoneCode("(212) 6007989253"), "6007989253", "Returned number is not correct");
    }
}
