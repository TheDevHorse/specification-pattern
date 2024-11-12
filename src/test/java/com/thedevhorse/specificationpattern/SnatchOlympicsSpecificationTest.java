package com.thedevhorse.specificationpattern;

import com.thedevhorse.specificationpattern.domian.specification.SnatchOlympicsSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SnatchOlympicsSpecificationTest {

    private SnatchOlympicsSpecification specification;

    @BeforeEach
    void setUp() {
        specification = new SnatchOlympicsSpecification();
    }

    @Test
    void givenSnatchWeightBelowMin_whenSpecificationIsTested_thenFalseIsReturned() {
        //Given
        double cleanAndJerkWeight = 140.0;
        double snatchWeight = 90.0;

        // When
        boolean result = specification.toPredicate().test(snatchWeight, cleanAndJerkWeight);

        // Then
        assertFalse(result);
    }

    @Test
    void givenSnatchWeightAboveMin_whenSpecificationIsTested_thenTrueReturned() {
        //Given
        double cleanAndJerkWeight = 210.0;
        double snatchWeight = 130.0;

        // When
        boolean result = specification.toPredicate().test(snatchWeight, cleanAndJerkWeight);

        // Then
        assertTrue(result);
    }
}