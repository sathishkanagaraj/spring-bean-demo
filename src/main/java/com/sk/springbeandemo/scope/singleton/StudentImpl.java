package com.sk.springbeandemo.scope.singleton;

import com.sk.springbeandemo.scope.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("sin_s")//make sure to remove while running the proto test
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
