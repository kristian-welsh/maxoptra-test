package com.maxoptra.kwelsh.model;

import com.maxoptra.kwelsh.model.card.UnvalidatedCard;
import com.maxoptra.kwelsh.validation.model.ValidCard;
import io.vavr.control.Either;

public class RegisterCardSuccessResponse extends RegisterCardResponse {
    public RegisterCardSuccessResponse(ValidCard card) {
        super(true, Either.right(card));
    }
}
