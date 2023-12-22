package com.sk.springbeandemo.scope;

public interface Student {

    default int getEnglishAnnualMark(int rollNumber){
        return 0;
    }
}
