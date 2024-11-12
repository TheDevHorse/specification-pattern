package com.thedevhorse.specificationpattern;

import com.thedevhorse.specificationpattern.domian.Weightlifting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightliftingTest {

    @Test
    void givenOlympicsWeightAboveMin_whenWeightliftingIsCreated_thenIsEligibleForOlympics() {
        //Given
        String athleteName = "John Doe";
        double cleanAndJerkWeight = 230.0;
        double snatchWeight = 130.0;

        // When
        Weightlifting weightlifting = Weightlifting.create(athleteName, snatchWeight, cleanAndJerkWeight);

        // Then
        assertNotNull(weightlifting);
        assertTrue(weightlifting.isEligibleForOlympics());
    }

    @Test
    void givenOlympicsWeightBelowMin_whenWeightliftingIsCreated_thenIsNotEligibleForOlympics() {
        //Given
        String athleteName = "John Doe";
        double cleanAndJerkWeight = 200.0;
        double snatchWeight = 90.0;

        // When
        Weightlifting weightlifting = Weightlifting.create(athleteName, snatchWeight, cleanAndJerkWeight);

        // Then
        assertNotNull(weightlifting);
        assertFalse(weightlifting.isEligibleForOlympics());
    }
}