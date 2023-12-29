package com.sk.springbeandemo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChildBean extends ParentBean{

    private final String surName;
    private final boolean adult;

    public ChildBean(@Value("Lil John") String surName, @Value("false") boolean adult) {
        super(surName);
        this.surName = surName;
        this.adult = adult;
    }

    @Override
    public String toString() {
        return "ChildBean{" +
                "familyName='" + getFamilyName() + '\'' +
                "surName='" + surName + '\'' +
                ", adult=" + adult +
                '}';
    }
}
