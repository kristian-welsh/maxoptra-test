package com.maxoptra.kwelsh.model;

public class RegisterCardSuccessResponse extends RegisterCardResponse {
    public RegisterCardSuccessResponse(UnvalidatedCard card) {
        super(true, card);
    }
}
