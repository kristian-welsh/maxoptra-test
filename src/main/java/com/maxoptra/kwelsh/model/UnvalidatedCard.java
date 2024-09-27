package com.maxoptra.kwelsh.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.maxoptra.kwelsh.cards.ExpungedCardNumberSerializer;
import com.maxoptra.kwelsh.model.rest.RegisterCardRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnvalidatedCard {
    private final String bankName;
    @JsonSerialize(using = ExpungedCardNumberSerializer.class)
    private final String cardNumber;
    private final String expiryDate;
    public static UnvalidatedCard fromRequest(RegisterCardRequest request) {
        return new UnvalidatedCard(request.getBankName(), request.getCardNumber(), request.getExpiryDate());
    }
}
