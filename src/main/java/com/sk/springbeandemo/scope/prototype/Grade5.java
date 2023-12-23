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
    private final BrightStudent brightStudent;
    private final BrilliantStudent brilliantStudent;

    private final OutstandingStudent outstandingStudent;

    public Grade5(@Qualifier("proto_s") Student student, BrightStudent brightStudent, BrilliantStudent brilliantStudent, OutstandingStudent outstandingStudent) {
        this.brightStudent = brightStudent;
        this.brilliantStudent = brilliantStudent;
        this.student = student;
        this.outstandingStudent = outstandingStudent;
        LOGGER.info("Grade5 instantiated and initialised..");
    }

    public int retrieveStudentEnglishAnnualMark(){
        return student.getEnglishAnnualMark(123);
    }

    public int retrieveBrightStudentMark(){
        return brightStudent.getMark();
    }

    public int retrieveBrilliantStudentMark(){
        return brilliantStudent.getMark();
    }

    public int retrieveOutstandingStudentMark(){
        return outstandingStudent.getMark();
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
