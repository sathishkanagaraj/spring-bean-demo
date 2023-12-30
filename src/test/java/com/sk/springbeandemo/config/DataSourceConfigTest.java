package com.sk.springbeandemo.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class DataSourceConfigTest {

    @Test
    public void testDriverClassName(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
        String dataSourceString = context.getBean("dataSourceString", String.class);
        assertNotNull(dataSourceString);
        assertEquals(dataSourceString, "org.h2.Driverjdbc:h2:~/sample");
    }
}
