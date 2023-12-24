package com.sk.springbeandemo.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnotherComplexBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnotherComplexBean.class);

    private SmallBean smallBean;
    private AnotherSimpleBean anotherSimpleBean;

    public AnotherComplexBean() {
        LOGGER.info("Stage 1 : Calling the current bean for instantiation");
    }

    @Autowired
    public void setSmallBean(SmallBean simpleBean) {
        LOGGER.info("Stage 3 : adding dependency by calling the setter");
    }


    //instead of post construct , defining @Bean with initMethod property in config(KnowStagesConfig) class will call the init method
    //make sure its private which restricts from others calling this except Spring IoC itself.
    @PostConstruct
    private void beanInitMethod(){
        LOGGER.info("Stage 4 - calling the invoked(current)bean init method");
        long currentTime = System.currentTimeMillis();
        if(currentTime % 2 ==0){
            anotherSimpleBean = new AnotherSimpleBean();
        }
    }

    //make sure its private which restricts from others calling this except Spring IoC itself.
    @PreDestroy
    private void killIt(){
        LOGGER.info("Stage 6 - Destroy beans");
    }

}
