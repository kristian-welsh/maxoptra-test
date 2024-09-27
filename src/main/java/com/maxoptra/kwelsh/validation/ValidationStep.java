package com.maxoptra.kwelsh.validation;

import com.maxoptra.kwelsh.model.UnvalidatedCard;
import com.maxoptra.kwelsh.model.errors.CardValidationError;

import java.util.Optional;

public interface ValidationStep {
    Optional<CardValidationError> validate(UnvalidatedCard card);
}
