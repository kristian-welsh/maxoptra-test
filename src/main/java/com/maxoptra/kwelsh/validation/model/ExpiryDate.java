package com.maxoptra.kwelsh.validation.model;

import com.maxoptra.kwelsh.model.Wrapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExpiryDate extends Wrapper<LocalDate> {
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    public ExpiryDate(LocalDate value) {
        super(value);
    }

    public static ExpiryDate fromString(String expiryDate) {
        return new ExpiryDate(LocalDate.parse("01/" + expiryDate, DateTimeFormatter.ofPattern(DATE_FORMAT)));
    }
}
