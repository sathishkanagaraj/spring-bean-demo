package com.sk.springbeandemo.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnotherSimpleBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnotherSimpleBean.class);
    public AnotherSimpleBean() {
        LOGGER.info("Stage 5 - Instantiating the AnotherSimple Bean");
    }
}
