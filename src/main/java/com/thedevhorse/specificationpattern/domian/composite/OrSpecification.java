package com.thedevhorse.specificationpattern.domian.composite;

import java.util.function.BiPredicate;

public class OrSpecification<T> extends CompositeSpecification<T> {

    private final Specification<T> firstSpecification;
    private final Specification<T> secondSpecification;

    public OrSpecification(Specification<T> firstSpecification, Specification<T> secondSpecification) {
        this.firstSpecification = firstSpecification;
        this.secondSpecification = secondSpecification;
    }

    @Override
    public BiPredicate<T, T> toPredicate() {
        return firstSpecification.toPredicate().or(secondSpecification.toPredicate());
    }
}
