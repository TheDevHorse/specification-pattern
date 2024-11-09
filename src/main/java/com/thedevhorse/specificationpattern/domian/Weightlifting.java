package com.thedevhorse.specificationpattern.domian;

import com.thedevhorse.specificationpattern.domian.specification.*;

public class Weightlifting {

    private String athleteName;

    private boolean eligibleForOlympics;
    private boolean eligibleForWorldChampionships;

    private Weightlifting(String athleteName,
                          double snatchWeight,
                          double cleanAndJerkWeight) {
        this.athleteName = athleteName;

        setEligibleForOlympics(
                snatchWeight,
                cleanAndJerkWeight
        );

        setEligibleForWorldChampionships(
                snatchWeight,
                cleanAndJerkWeight
        );
    }

    public static Weightlifting create(final String name,
                                       final double snatchWeight,
                                       final double cleanAndJerkWeight) {
        return new Weightlifting(
                name,
                snatchWeight,
                cleanAndJerkWeight
        );
    }

    public String athleteName() {
        return athleteName;
    }

    public boolean isEligibleForOlympics() {
        return eligibleForOlympics;
    }
    public boolean isEligibleForWorldChampionships() {
        return eligibleForWorldChampionships;
    }

    private void setEligibleForOlympics(double snatchWeight, double cleanAndJerkWeight) {
        this.eligibleForOlympics = new TotalOlympicsSpecification()
                .toPredicate()
                .or(
                        new CleanAndJerkOlympicsSpecification()
                                .toPredicate()
                                .and(new SnatchOlympicsSpecification().toPredicate())
                )
                .test(snatchWeight, cleanAndJerkWeight);
    }

    private void setEligibleForWorldChampionships(double snatchWeight, double cleanAndJerkWeight) {
        this.eligibleForWorldChampionships = new TotalWorldChampionshipsSpecification()
                .toPredicate()
                .or(
                        new CleanAndJerkWorldChampionshipsSpecification()
                                .toPredicate()
                                .and(new SnatchWorldChampionshipsSpecification().toPredicate())
                )
                .test(snatchWeight, cleanAndJerkWeight);
    }
}
