package com.thedevhorse.specificationpattern;


import com.thedevhorse.specificationpattern.domian.atomic.EmailSpecification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailSpecificationTest {

    private EmailSpecification specification;

    @BeforeEach
    void setUp() {
        specification = new EmailSpecification();
    }

    @Test
    void givenValidEmail_whenSpecificationIsTested_thenTrueIsReturned() {
        //Given
        String validEmail = "john@gmail.com";
        // When
        boolean result = specification.isSatisfiedBy(validEmail);

        // Then
        assertTrue(result);
    }

    @Test
    void givenInvalidEmail_whenSpecificationIsTested_thenFalseIsReturned() {
        //Given
        String invalidEmail = "johngmail.com";
        // When
        boolean result = specification.isSatisfiedBy(invalidEmail);

        // Then
        assertFalse(result);
    }
}
