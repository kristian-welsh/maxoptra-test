package com.maxoptra.kwelsh.model.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardError {
    Class<? extends CardError> errorType;
    String errorMesssage;
}
