package com.sk.springbeandemo.scope.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BrilliantStudent {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrilliantStudent.class);
    private final int mark;
    public BrilliantStudent() {
        Random random = new Random();
        mark = random.nextInt(50) + 50;
        LOGGER.info("Brilliant student mark -{}", mark);
    }

    public int getMark(){
        return mark;
    }
}
