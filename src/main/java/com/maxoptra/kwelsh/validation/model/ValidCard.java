package com.maxoptra.kwelsh.validation.model;

import com.maxoptra.kwelsh.model.UnvalidatedCard;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidCard {
    private BankName bankName;
    private CardNumber cardNumber;
    private ExpiryDate expiryDate;

    public static ValidCard fromUnvalidated(UnvalidatedCard card) {
        return new ValidCard(
                new BankName(card.getBankName()),
                new CardNumber(card.getCardNumber()),
                ExpiryDate.fromString(card.getExpiryDate()));
    }
}
