package com.sk.springbeandemo.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeanImpl implements SimpleBean {
    public static final Logger LOGGER = LoggerFactory.getLogger(SimpleBeanImpl.class);
    public SimpleBeanImpl() {
        LOGGER.info("called from SimpleBeanImpl");
    }
}
