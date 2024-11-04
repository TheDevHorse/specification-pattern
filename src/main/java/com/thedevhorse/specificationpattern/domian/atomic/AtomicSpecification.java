package com.thedevhorse.specificationpattern.domian.atomic;

public interface AtomicSpecification<T> {
    boolean isSatisfiedBy(T t);

}
