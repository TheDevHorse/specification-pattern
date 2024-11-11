package com.thedevhorse.specificationpattern;

import com.thedevhorse.specificationpattern.domian.specification.CleanAndJerkOlympicsSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CleanAndJerkOlympicsSpecificationTest {

    private CleanAndJerkOlympicsSpecification specification;

    @BeforeEach
    void setUp() {
        specification = new CleanAndJerkOlympicsSpecification();
    }

    @Test
    void givenCleanAndJerkWeightBelowMin_whenSpecificationIsTested_thenFalseIsReturned() {
        //Given
        double cleanAndJerkWeight = 140.0;
        double snatchWeight = 90.0;

        // When
        boolean result = specification.toPredicate().test(snatchWeight, cleanAndJerkWeight);

        // Then
        assertFalse(result);
    }

    @Test
    void givenCleanAndJerkWeightAboveMin_whenSpecificationIsTested_thenTrueReturned() {
        //Given
        double cleanAndJerkWeight = 210.0;
        double snatchWeight = 100.0;

        // When
        boolean result = specification.toPredicate().test(snatchWeight, cleanAndJerkWeight);

        // Then
        assertTrue(result);
    }
}