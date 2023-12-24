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

    private AnotherSimpleBean anotherSimpleBean;

    public ComplexBeanImpl(SimpleBean simpleBean,
                           @Value("${app.timeout}") String timeout,
                           @Value("${app.wakeup}") int wakeup) {
        LOGGER.info("Complex Bean Impl constructor identified for instantiation even with additional arguments in the constructor");
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

    /**
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("Now the properties all set, we can do something funky");
        anotherSimpleBean = new AnotherSimpleBean();

    }

    /**
     * @throws Exception - exception
     */
    @Override
    public void destroy() throws Exception {
        LOGGER.info("Disposable Bean - I am always called at the end of Bean lifecycle and I will be called only once in the lifecycle");
    }
}
