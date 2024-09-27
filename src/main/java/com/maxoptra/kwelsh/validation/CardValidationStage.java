package com.maxoptra.kwelsh.validation;

import com.maxoptra.kwelsh.model.UnvalidatedCard;
import com.maxoptra.kwelsh.model.errors.CardValidationError;
import com.maxoptra.kwelsh.validation.model.ValidCard;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CardValidationStage {

    private final List<ValidationStep> validations;

    public CardValidationStage(
            @Autowired CardNumberFormatValidation cardNumberFormatValidation) {
        validations = new ArrayList<>();
        validations.add(cardNumberFormatValidation);
        // etc. for other validations
    }

    public Either<CardValidationError, ValidCard> validate(UnvalidatedCard card) {
        return validations.stream()
                .map(validationStep -> validationStep.validate(card))
                .filter(Optional::isPresent).map(Optional::get).findFirst()
                .map(Either::<CardValidationError, ValidCard>left)
                .orElseGet(() -> Either.right(ValidCard.fromUnvalidated(card)));
    }
}
