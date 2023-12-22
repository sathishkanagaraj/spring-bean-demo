package com.sk.springbeandemo.scope.prototype;

import com.sk.springbeandemo.scope.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("proto_s")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
proxyMode = ScopedProxyMode.INTERFACES)
public class StudentImpl implements Student {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentImpl.class);

    private final int mark;

    public StudentImpl(@Value("123") int rollNumber) {
        Random random = new Random();
        mark = random.nextInt(10) + 50;
        LOGGER.info("Earned mark by the student {} - {} - {}",this.hashCode(), rollNumber, mark);
    }
//727250772
//727250772
    @Override
    public int getEnglishAnnualMark(int rollNumber) {
        LOGGER.info("Student Impl called");
        return mark;
    }

}
