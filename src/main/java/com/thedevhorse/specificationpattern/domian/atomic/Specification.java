package com.thedevhorse.specificationpattern.domian.atomic;

public interface Specification<T> {
    boolean isSatisfiedBy(T t);

}
