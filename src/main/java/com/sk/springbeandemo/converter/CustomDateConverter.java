package com.sk.springbeandemo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CustomDateConverter implements Converter<String, LocalDate> {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /**
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return local date
     */
    @Override
    public LocalDate convert(@NonNull String source) {
        return LocalDate.parse(source, formatter);
    }
}
