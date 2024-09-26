package com.maxoptra.kwelsh.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterCardResponse {
    private boolean successful;
    private UnvalidatedCard card;
}
