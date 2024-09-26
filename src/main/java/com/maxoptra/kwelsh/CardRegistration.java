package com.maxoptra.kwelsh;

import com.maxoptra.kwelsh.model.card.UnvalidatedCard;
import com.maxoptra.kwelsh.model.errors.CardError;
import com.maxoptra.kwelsh.model.errors.CardValidationError;
import com.maxoptra.kwelsh.validation.CardValidation;
import com.maxoptra.kwelsh.validation.model.ValidCard;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardRegistration {
    private final CardValidation cardValidation;

    public CardRegistration(@Autowired CardValidation cardValidation) {
        this.cardValidation = cardValidation;
    }

    public Either<? extends CardError, ValidCard> register(UnvalidatedCard submitedCard) {
        Either<CardValidationError, ValidCard> validationResult = cardValidation.validate(submitedCard);
        // todo: store card
        return validationResult;
    }
}
