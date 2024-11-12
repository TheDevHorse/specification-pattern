package com.thedevhorse.specificationpattern;

import com.thedevhorse.specificationpattern.domian.specification.TotalOlympicsSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TotalOlympicsSpecificationTest {

    private TotalOlympicsSpecification specification;

    @BeforeEach
    void setUp() {
        specification = new TotalOlympicsSpecification();
    }

    @Test
    void givenTotalWeightBelowMin_whenSpecificationIsTested_thenFalseIsReturned() {
        //Given
        double cleanAndJerkWeight = 140.0;
        double snatchWeight = 90.0;

        // When
        boolean result = specification.toPredicate().test(snatchWeight, cleanAndJerkWeight);

        // Then
        assertFalse(result);
    }

    @Test
    void givenTotalWeightAboveMin_whenSpecificationIsTested_thenTrueReturned() {
        //Given
        double cleanAndJerkWeight = 230.0;
        double snatchWeight = 130.0;

        // When
        boolean result = specification.toPredicate().test(snatchWeight, cleanAndJerkWeight);

        // Then
        assertTrue(result);
    }
}