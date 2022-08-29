package com.harshit.service;

import java.util.List;

import com.harshit.entity.Country;

public interface CountryService {
    Country getCountryById(Long id);
    Country getCountryByName(String name);
    List<Country> getCountryList();
}
