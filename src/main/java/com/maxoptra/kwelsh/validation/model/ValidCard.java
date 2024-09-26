package com.maxoptra.kwelsh.validation.model;

import com.maxoptra.kwelsh.model.card.BankName;
import com.maxoptra.kwelsh.model.card.CardNumber;
import com.maxoptra.kwelsh.model.card.ExpiryDate;
import com.maxoptra.kwelsh.model.card.UnvalidatedCard;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class ValidCard {
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    private BankName bankName;
    private CardNumber cardNumber;
    private ExpiryDate expiryDate;

    public static ValidCard fromUnvalidated(UnvalidatedCard card) {
        return new ValidCard(
                new BankName(card.getBankName()),
                new CardNumber(card.getCardNumber()),
                new ExpiryDate(
                        LocalDate.parse(card.getExpiryDate(), DateTimeFormatter.ofPattern(DATE_FORMAT))));
    }
}
