package com.maxoptra.kwelsh.model.rest;

import com.maxoptra.kwelsh.model.UnvalidatedCard;
import com.maxoptra.kwelsh.model.errors.CardError;
import lombok.Data;

@Data
public class RegisterCardFailureResponse extends RegisterCardResponse {
    private final CardError error;
    private final UnvalidatedCard card;

    public RegisterCardFailureResponse(CardError error, UnvalidatedCard card) {
        super(false);
        this.error = error;
        this.card = card;
    }
}
