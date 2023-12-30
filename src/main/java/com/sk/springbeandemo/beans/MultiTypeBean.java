package com.sk.springbeandemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MultiTypeBean {
    private Date birthDate;
    private char achar;

    public Date getBirthDate() {
        return birthDate;
    }

    @Autowired
    public void setBirthDate(@Value("1947-08-15") Date birthDate) {
        this.birthDate = birthDate;
    }

    public char getAchar() {
        return achar;
    }

    @Autowired
    public void setAchar(@Value("1") char achar) {
        this.achar = achar;
    }
}
