package com.maxoptra.kwelsh.model.rest;

import com.maxoptra.kwelsh.model.UnvalidatedCard;
import com.maxoptra.kwelsh.validation.model.ValidCard;
import lombok.Data;

@Data
public class RegisterCardSuccessResponse extends RegisterCardResponse {
    private final ValidCard card;

    public RegisterCardSuccessResponse(ValidCard card) {
        super(true);
        this.card = card;
    }
}
