package com.maxoptra.kwelsh.validation.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.maxoptra.kwelsh.cards.ExpungedCardNumberSerializer;
import lombok.Data;

@Data
public class CardNumber {
    @JsonSerialize(using = ExpungedCardNumberSerializer.class)
    private final String value;

    public CardNumber(String value) {
        this.value = value;
    }
}

