package com.sk.springbeandemo.inherit;

import com.sk.springbeandemo.beans.ChildBean;
import com.sk.springbeandemo.beans.ParentBean;
import com.sk.springbeandemo.config.InheritConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InheritTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(InheritTest.class);
    @Test
    public void testParentInheritedFromChild(){
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(InheritConfig.class);
        ParentBean parent = ctx.getBean("parentBean", ParentBean.class);
        ChildBean child = ctx.getBean("childBean", ChildBean.class);
        LOGGER.info("Parent Bean - {}", parent);
        LOGGER.info("Child Bean - {}", child);
        assertNotEquals(parent.getSurName(), child.getSurName());
        assertEquals(parent.getFamilyName(), child.getFamilyName());
        ctx.close();
    }
}
