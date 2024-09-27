package com.maxoptra.kwelsh.validation;

import com.maxoptra.kwelsh.model.UnvalidatedCard;
import com.maxoptra.kwelsh.model.errors.CardValidationError;
import io.vavr.control.Try;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class CardNumberFormatValidation implements ValidationStep {
    private static final String FIELD_NAME = "cardNumber";
    private static final String ERROR_MESSAGE = "must only contain numerical digits separated by dash characters";

    @Override
    public Optional<CardValidationError> validate(UnvalidatedCard card) {
        if(!cardNumberHasFourGroups(card)) {
            return createError(card);
        }
        if(cardNumberHasNonDigits(card)) {
            return createError(card);
        }
        return Optional.empty();
    }

    private boolean cardNumberHasFourGroups(UnvalidatedCard card) {
        return Arrays.stream(splitGroups(card.getCardNumber())).count() == 4;
    }

    private boolean cardNumberHasNonDigits(UnvalidatedCard card) {
        return Arrays.stream(splitGroups(card.getCardNumber()))
                .filter(this::stringContainsOnlyDigits).count() != 4;
    }

    private String[] splitGroups(String cardNumber) {
        return cardNumber.split("-");
    }

    private boolean stringContainsOnlyDigits(String string) {
        return Try.of(() -> Integer.valueOf(string)).map((integer) -> true).getOrElseGet((it) -> false);
    }

    private Optional<CardValidationError> createError(UnvalidatedCard card) {
        return Optional.of(new CardValidationError(FIELD_NAME, card.getCardNumber(), ERROR_MESSAGE));
    }
}
