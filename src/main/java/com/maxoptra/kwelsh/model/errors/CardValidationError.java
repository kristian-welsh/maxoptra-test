package com.maxoptra.kwelsh.model.errors;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CardValidationError extends CardError {
    String invalidField;
    String fieldValue;
    public CardValidationError(String invalidFieldName, String fieldValue, String errorMessage) {
        super(CardValidationError.class, errorMessage);
    }
}
