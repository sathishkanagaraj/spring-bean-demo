package com.sk.springbeandemo.scope.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class OutstandingStudent {

    private static final Logger LOGGER = LoggerFactory.getLogger(OutstandingStudent.class);
    private final int mark;

    public OutstandingStudent() {
        Random random = new Random();
        mark = random.nextInt(9) + 90;
        LOGGER.info("outstanding student mark - {}",mark);
    }

    public int getMark(){
        return mark;
    }
}
