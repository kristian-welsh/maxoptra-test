package com.maxoptra.kwelsh.model;

import com.maxoptra.kwelsh.model.card.UnvalidatedCard;

public class RegisterCardSuccessResponse extends RegisterCardResponse {
    public RegisterCardSuccessResponse(UnvalidatedCard card) {
        super(true, card);
    }
}
