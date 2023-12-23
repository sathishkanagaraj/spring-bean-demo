package com.sk.springbeandemo.scope.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BrightStudent {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrightStudent.class);
    private final int mark;
    public BrightStudent() {
        Random random = new Random();
        mark = random.nextInt(50) + 50;
        LOGGER.info("Bright student mark - {}", mark);
    }

    public int getMark() {
        return mark;
    }
}
