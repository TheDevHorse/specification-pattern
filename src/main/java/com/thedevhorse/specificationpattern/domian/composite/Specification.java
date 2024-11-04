package com.thedevhorse.specificationpattern.domian.composite;

import java.util.function.Predicate;

public interface Specification<T> {
    Predicate<T> toPredicate();
}
