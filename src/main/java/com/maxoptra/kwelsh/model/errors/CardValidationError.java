package com.maxoptra.kwelsh.model.errors;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CardValidationError extends CardError {
    String fieldName;
    String fieldValue;
    public CardValidationError(String fieldName, String fieldValue, String errorMessage) {
        super(CardValidationError.class, errorMessage);
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
