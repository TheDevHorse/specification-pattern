package com.thedevhorse.specificationpattern.domian.atomic;

import java.util.regex.Pattern;

public class EmailSpecification implements Specification<String> {

    @Override
    public boolean isSatisfiedBy(String email) {
        return Pattern.compile("^(.+)@(\\S+)$")
                .matcher(email)
                .matches();
    }
}
