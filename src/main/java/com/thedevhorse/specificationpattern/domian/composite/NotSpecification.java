package com.thedevhorse.specificationpattern.domian.composite;

import java.util.function.BiPredicate;

public class NotSpecification<T> extends CompositeSpecification<T> {

    private final Specification<T> specification;

    public NotSpecification(Specification<T> specification) {
        this.specification = specification;
    }

    @Override
    public BiPredicate<T, T> toPredicate() {
        return specification.toPredicate().negate();
    }
}
