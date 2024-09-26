package com.maxoptra.kwelsh.model;

import com.maxoptra.kwelsh.model.card.UnvalidatedCard;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterCardResponse {
    private boolean successful;
    private UnvalidatedCard card;
}
