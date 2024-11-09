package com.thedevhorse.specificationpattern.domian.specification;

import com.thedevhorse.specificationpattern.domian.composite.CompositeSpecification;

import java.util.function.Predicate;

public class SnatchOlympicsSpecification extends CompositeSpecification<Double> {
    @Override
    public Predicate<Double> toPredicate() {
        return weight -> weight > 120;
    }
}
