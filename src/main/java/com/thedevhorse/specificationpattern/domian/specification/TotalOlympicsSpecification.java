package com.thedevhorse.specificationpattern.domian.specification;

import com.thedevhorse.specificationpattern.domian.composite.CompositeSpecification;

import java.util.function.BiPredicate;

public class TotalOlympicsSpecification extends CompositeSpecification<Double> {

    private static final double MINIMUM_WEIGHT = 320.0;

    @Override
    public BiPredicate<Double, Double> toPredicate() {
        return (snatch, cleanAndJerk) -> snatch + cleanAndJerk > MINIMUM_WEIGHT;
    }
}
