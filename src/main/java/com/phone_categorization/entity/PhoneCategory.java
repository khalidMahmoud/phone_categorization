package com.phone_categorization.entity;

public class PhoneCategory
{
    private String phone;

    private String country;

    private String code;

    private String number;

    private String state;

    public PhoneCategory()
    {
    }

    public PhoneCategory(String phone, String country, String code, String number, String state)
    {
        this.phone = phone;
        this.country = country;
        this.code = code;
        this.number = number;
        this.state = state;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }
}
