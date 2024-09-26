package com.maxoptra.kwelsh.model.card;

import com.maxoptra.kwelsh.model.Wrapper;

import java.time.ZonedDateTime;

public class ExpiryDate extends Wrapper<ZonedDateTime> {
    public ExpiryDate(ZonedDateTime value) {
        super(value);
    }
}
