package com.sk.springbeandemo.scope;

import com.sk.springbeandemo.config.AppConfig;
import com.sk.springbeandemo.scope.prototype.BrightStudent;
import com.sk.springbeandemo.scope.prototype.BrilliantStudent;
import com.sk.springbeandemo.scope.prototype.OutstandingStudent;
import com.sk.springbeandemo.scope.singleton.Grade5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class Grade5Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Grade5Test.class);
    private ConfigurableApplicationContext ctx;

    @BeforeEach
    void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @AfterEach
    void tearDown() {
        ctx.close();
    }

    @Test
    void retrieveStudentEnglishAnnualMark() {
        Grade5 grade5 = ctx.getBean("sin_g",Grade5.class);
        Grade5 grade5_2 = ctx.getBean("sin_g",Grade5.class);
        LOGGER.info("Student English mark retrieved from Grade5 - {}",grade5.retrieveStudentEnglishAnnualMark());
        LOGGER.info("Student English mark retrieved from Grade5_2 - {}",grade5_2.retrieveStudentEnglishAnnualMark());
        assertEquals(grade5, grade5_2);
        assertEquals(grade5.retrieveStudentEnglishAnnualMark(), grade5_2.retrieveStudentEnglishAnnualMark());
    }

    @Test
    void checkStudentAnnualEnglishMarkIsDifferentForEachInstantiationOfGrade5(){
        com.sk.springbeandemo.scope.prototype.Grade5 grade5 = ctx.getBean("proto_g",com.sk.springbeandemo.scope.prototype.Grade5.class);
        com.sk.springbeandemo.scope.prototype.Grade5 grade5_2 = ctx.getBean("proto_g",com.sk.springbeandemo.scope.prototype.Grade5.class);
        LOGGER.info("P -> Student English mark retrieved from Grade5 - {}",grade5.retrieveStudentEnglishAnnualMark());
        LOGGER.info("P -> Student English mark retrieved from Grade5_2 - {}",grade5_2.retrieveStudentEnglishAnnualMark());
        // note that Grade5 is Singleton and the Student wired in Grade5 is a proxy and
        //that proxy is singleton as a result the below assertion is true.
        //Student interface is now a proxy class created by spring and it is singleton
        assertEquals(grade5, grade5_2);
        Student s1 = ctx.getBean("proto_s", Student.class);
        Student s2 = ctx.getBean("proto_s", Student.class);
        assertEquals(s1, s2);
        //the below is not applicable because StudentImpl is now of type Proxy and not Student.
        //So the below will throw runtime exception
       /* StudentImpl sI1 = ctx.getBean("proto_s", StudentImpl.class);
        StudentImpl sI2 = ctx.getBean("proto_s", StudentImpl.class);
        assertEquals(sI1, sI2);*/

        //So the call to instantiate StudentImpl happens twice can only be tested by logging or
        // I have just created a method which retrieve the value which is initialised during instantiation.
        assertNotEquals(grade5.retrieveStudentEnglishAnnualMark(), grade5_2.retrieveStudentEnglishAnnualMark());
    }

    @Test
    public void testPrototypeBehavesSingletonWithoutProxyBeingSet(){
        BrightStudent bean1 = ctx.getBean(BrightStudent.class);
        BrightStudent bean2 = ctx.getBean(BrightStudent.class);
        // it proves it still a singleton even though setting the scope to prototype
        assertEquals(bean1, bean2);
        assertEquals(bean1.getMark(), bean2.getMark());
    }

    @Test
    public void testPrototypeBehaveWellWhenProxyIsSet(){
        BrilliantStudent bean1 = ctx.getBean(BrilliantStudent.class);
        BrilliantStudent bean2 = ctx.getBean(BrilliantStudent.class);
        // two beans were equal because proxy was created and injected
        // in the place of the real bean by the spring IoC container
        assertEquals(bean1, bean2);
        // but the bean is clearly instantiated twice because of scope prototype
        // and initialised mark with different random integer twice when called twice.
        //that is why getMark is not equal because of two random integers were generated
        assertNotEquals(bean1.getMark(), bean2.getMark());
    }

    @Test
    public void testMarkAnnotationThatReflectAsSameASBrilliant(){
        OutstandingStudent bean1 = ctx.getBean(OutstandingStudent.class);
        OutstandingStudent bean2 = ctx.getBean(OutstandingStudent.class);
        assertNotEquals(bean1.getMark(), bean2.getMark());
    }
}