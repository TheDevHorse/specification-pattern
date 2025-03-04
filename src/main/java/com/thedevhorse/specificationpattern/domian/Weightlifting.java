package com.thedevhorse.specificationpattern.domian;

import com.thedevhorse.specificationpattern.domian.atomic.EmailSpecification;
import com.thedevhorse.specificationpattern.domian.specification.CleanAndJerkOlympicsSpecification;
import com.thedevhorse.specificationpattern.domian.specification.CleanAndJerkWorldChampionshipsSpecification;
import com.thedevhorse.specificationpattern.domian.specification.SnatchOlympicsSpecification;
import com.thedevhorse.specificationpattern.domian.specification.SnatchWorldChampionshipsSpecification;

public class Weightlifting {

    private String athleteName;

    private String athleteEmail;

    private boolean eligibleForOlympics;
    private boolean eligibleForWorldChampionships;

    private Weightlifting(String athleteName,
                          String athleteEmail,
                          double snatchWeight,
                          double cleanAndJerkWeight) {
        this.athleteName = athleteName;
        setAthleteEmail(athleteEmail);
        setEligibleForOlympics(
                snatchWeight,
                cleanAndJerkWeight
        );
        setEligibleForWorldChampionships(
                snatchWeight,
                cleanAndJerkWeight
        );
    }

    public static Weightlifting create(final String athleteName,
                                       final String athleteEmail,
                                       final double snatchWeight,
                                       final double cleanAndJerkWeight) {
        return new Weightlifting(
                athleteName,
                athleteEmail,
                snatchWeight,
                cleanAndJerkWeight
        );
    }

    public String athleteName() {
        return athleteName;
    }

    public String athleteEmail() {
        return athleteEmail;
    }

    public boolean isEligibleForOlympics() {
        return eligibleForOlympics;
    }
    public boolean isEligibleForWorldChampionships() {
        return eligibleForWorldChampionships;
    }

    private void setEligibleForOlympics(double snatchWeight, double cleanAndJerkWeight) {
        this.eligibleForOlympics = new CleanAndJerkOlympicsSpecification()
                                .toPredicate()
                                .and(new SnatchOlympicsSpecification().toPredicate())
                .test(snatchWeight, cleanAndJerkWeight);
    }

    private void setEligibleForWorldChampionships(double snatchWeight, double cleanAndJerkWeight) {
        this.eligibleForWorldChampionships = new CleanAndJerkWorldChampionshipsSpecification()
                                .toPredicate()
                                .and(new SnatchWorldChampionshipsSpecification().toPredicate())
                .test(snatchWeight, cleanAndJerkWeight);
    }

    private void setAthleteEmail(String athleteEmail) {
        boolean isValidEmail = new EmailSpecification().isSatisfiedBy(athleteEmail);

        if(!isValidEmail) {
            throw new IllegalArgumentException("Invalid email.");
        }

        this.athleteEmail = athleteEmail;
    }
}
