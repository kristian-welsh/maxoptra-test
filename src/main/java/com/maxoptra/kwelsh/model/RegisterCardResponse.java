package com.maxoptra.kwelsh.model;

import com.maxoptra.kwelsh.model.card.UnvalidatedCard;
import com.maxoptra.kwelsh.validation.model.ValidCard;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterCardResponse {
    private boolean successful;
    private Either<UnvalidatedCard, ValidCard> card;
}
