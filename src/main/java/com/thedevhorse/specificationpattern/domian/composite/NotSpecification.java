package com.thedevhorse.specificationpattern.domian.composite;

import java.util.function.Predicate;

public class NotSpecification<T> extends CompositeSpecification<T> {

    private final Specification<T> specification;

    public NotSpecification(Specification<T> specification) {
        this.specification = specification;
    }

    @Override
    public Predicate<T> toPredicate() {
        return specification.toPredicate().negate();
    }
}
