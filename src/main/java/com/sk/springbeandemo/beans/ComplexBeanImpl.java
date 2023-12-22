package com.sk.springbeandemo.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ComplexBeanImpl implements ComplexBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComplexBeanImpl.class);
    private final SimpleBean simpleBean;
    private final String timeout;
    private final int wakeup;

    public ComplexBeanImpl(SimpleBean simpleBean,
                           @Value("${app.timeout}") String timeout,
                           @Value("${app.wakeup}") int wakeup) {
        LOGGER.info("Complex Bean Impl identified even with additional arguments in the constructor");
        this.simpleBean = simpleBean;
        this.timeout = timeout;
        this.wakeup = wakeup;
    }

    public String retrieveTimeout(){
        return timeout;
    }

    public int retrieveWakeUp(){
        return wakeup;
    }

    public SimpleBean retrieveSimpleBean(){
        int totalTime = Integer.parseInt(timeout) + wakeup;
        LOGGER.info("Total time taken : {}",totalTime);
        return simpleBean;
    }
}
