package com.sk.springbeandemo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParentBean {

    @Value("Smith")
    protected String familyName;
    protected String surName;

    public ParentBean(@Value("John") String surName) {
        this.surName = surName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public String toString() {
        return "ParentBean{" +
                "familyName='" + familyName + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
