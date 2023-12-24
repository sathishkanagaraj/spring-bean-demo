package com.sk.springbeandemo.config;

import com.sk.springbeandemo.beans.AnotherComplexBean;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class KnowStagesConfigTest {

    private ConfigurableApplicationContext ctx;
    @BeforeEach
    void setUp() {
        ctx = new AnnotationConfigApplicationContext(KnowStagesConfig.class);
    }

    @AfterEach
    void tearDown() {
        ctx.close();
    }

    @Test
    void anotherComplexBean() {
        AnotherComplexBean bean = ctx.getBean(AnotherComplexBean.class);
        assertNotNull(bean);
    }
}