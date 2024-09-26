package com.maxoptra.kwelsh.validation;

import com.maxoptra.kwelsh.model.card.UnvalidatedCard;
import com.maxoptra.kwelsh.model.errors.CardValidationError;
import com.maxoptra.kwelsh.validation.model.ValidCard;
import io.vavr.control.Either;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardValidationTest {
    private CardValidation cardValidaton;

    @BeforeEach
    public void setUp() {
        cardValidaton = new CardValidation();
    }

    @Test
    public void successCase() {
        UnvalidatedCard card = new UnvalidatedCard("American Express", "3700-0000-0000-0000", "dec 3030");
        Either<CardValidationError, ValidCard> result = cardValidaton.validate(card);
        assertTrue(result.isRight());
        assertEquals("American Express", result.get().getBankName().getValue());
        assertEquals("3700-0000-0000-0000", result.get().getCardNumber().getValue());
        assertEquals("dec 3030", result.get().getExpiryDate().getValue().toString());
    }
}