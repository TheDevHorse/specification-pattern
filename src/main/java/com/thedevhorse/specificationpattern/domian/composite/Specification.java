package com.thedevhorse.specificationpattern.domian.composite;

import java.util.function.BiPredicate;

public interface Specification<T> {
    BiPredicate<T, T> toPredicate();
}
