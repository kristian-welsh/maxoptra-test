package com.maxoptra.kwelsh.model.rest;

import com.maxoptra.kwelsh.model.UnvalidatedCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCardResponse {
    private boolean successful;
}
