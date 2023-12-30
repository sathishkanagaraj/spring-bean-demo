package com.sk.springbeandemo.converter;

import com.sk.springbeandemo.beans.MultiTypeBean;
import com.sk.springbeandemo.config.DateConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConverterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConverterTest.class);

    @Test
    public void testDateConfig(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DateConfig.class);
        MultiTypeBean bean = context.getBean(MultiTypeBean.class);
        LOGGER.info("Birth Date - {}", bean.getBirthDate());
        context.close();
    }
}
