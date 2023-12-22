package com.sk.springbeandemo.scope.prototype;

import com.sk.springbeandemo.scope.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("proto_g")
public class Grade5 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Grade5.class);

    private final Student student;

    public Grade5(@Qualifier("proto_s") Student student) {
        LOGGER.info("Grade5 instantiated and initialised..");
        this.student = student;
    }

    public int retrieveStudentEnglishAnnualMark(){
        return student.getEnglishAnnualMark(123);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade5 grade5 = (Grade5) o;
        return Objects.equals(student, grade5.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student)+31;
    }
}
