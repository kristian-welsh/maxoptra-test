package com.maxoptra.kwelsh.validation.model;

import com.maxoptra.kwelsh.model.card.BankName;
import com.maxoptra.kwelsh.model.card.CardNumber;
import com.maxoptra.kwelsh.model.card.ExpiryDate;
import com.maxoptra.kwelsh.model.card.UnvalidatedCard;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

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
                new ExpiryDate(ZonedDateTime.now()));// todo: interpret string from request/unvalidated card
    }
}
