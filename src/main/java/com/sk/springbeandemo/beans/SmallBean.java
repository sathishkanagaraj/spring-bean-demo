package com.sk.springbeandemo.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SmallBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(SmallBean.class);

    public SmallBean() {
        LOGGER.info("Stage 2 - Instantiate the dependent Small Bean");
    }
}
