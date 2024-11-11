package com.thedevhorse.specificationpattern.domian.composite;


import java.util.function.BiPredicate;

public class AndSpecification<T> extends CompositeSpecification<T> {

    private final Specification<T> firstSpecification;
    private final Specification<T> secondSpecification;

    public AndSpecification(Specification<T> firstSpecification, Specification<T> secondSpecification) {
        this.firstSpecification = firstSpecification;
        this.secondSpecification = secondSpecification;
    }

    @Override
    public BiPredicate<T, T> toPredicate() {
        return firstSpecification.toPredicate().and(secondSpecification.toPredicate());
    }
}
