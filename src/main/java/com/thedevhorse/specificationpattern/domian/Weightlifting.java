package com.thedevhorse.specificationpattern.domian;

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
    }

    private void setEligibleForWorldChampionships(double snatchWeight, double cleanAndJerkWeight) {

    }
}
