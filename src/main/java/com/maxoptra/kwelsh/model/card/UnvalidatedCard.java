package com.maxoptra.kwelsh.model.card;

import com.maxoptra.kwelsh.model.RegisterCardRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UnvalidatedCard {
    private final String bankName;
    private final String cardNumber;
    private final String expiryDate;
    public static UnvalidatedCard fromRequest(RegisterCardRequest request) {
        return new UnvalidatedCard(request.getBankName(), request.getCardNumber(), request.getExpiryDate());
    }
}
