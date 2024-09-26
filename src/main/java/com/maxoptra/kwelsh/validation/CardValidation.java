package com.maxoptra.kwelsh.validation;

import com.maxoptra.kwelsh.model.card.UnvalidatedCard;
import com.maxoptra.kwelsh.model.errors.CardValidationError;
import com.maxoptra.kwelsh.validation.model.ValidCard;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class CardValidation {
    public Either<CardValidationError, ValidCard> validate(UnvalidatedCard card) {
        return Either.right(ValidCard.fromUnvalidated(card));
    }
}
