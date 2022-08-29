package com.harshit.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.harshit.entity.Country;
import com.harshit.shared.MockResourceRepo;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CountryRepositoryTest {
    @Autowired
    CountryRepository countryRepository;

    private final Country COUNTRY_BANGLADESH = MockResourceRepo.getCountryBangladesh();

    @BeforeEach
    void setUp() {
        countryRepository.save(COUNTRY_BANGLADESH);
    }

    @AfterEach
    void tearDown() {
        countryRepository.deleteAll();
    }

    @Test
    void shouldReturnOptionalOfCountry_whenNameIsGiven() {
        Optional<Country> returnedCountry = countryRepository.findByName(COUNTRY_BANGLADESH.getName());

        assertThat(returnedCountry.isPresent()).isTrue();
    }
}