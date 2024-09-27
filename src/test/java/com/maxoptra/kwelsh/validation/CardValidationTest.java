package com.maxoptra.kwelsh.validation;

import com.maxoptra.kwelsh.model.UnvalidatedCard;
import com.maxoptra.kwelsh.model.errors.CardValidationError;
import com.maxoptra.kwelsh.validation.model.ValidCard;
import io.vavr.control.Either;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardValidationTest {
    private CardValidationStage cardValidaton;

    @BeforeEach
    public void setUp() {
        // manually create the validation steps to keep unit tests fasts
        // spring startup for each test is slow
        cardValidaton = new CardValidationStage(new CardNumberFormatValidation());
    }

    @Test
    public void successCase() {
        UnvalidatedCard card = new UnvalidatedCard("American Express", "3700-0000-0000-0000", "12/3030");
        Either<CardValidationError, ValidCard> result = cardValidaton.validate(card);
        assertTrue(result.isRight());
        assertEquals("American Express", result.get().getBankName().getValue());
        assertEquals("3700-0000-0000-0000", result.get().getCardNumber().getValue());
        assertEquals("3030-12-01", result.get().getExpiryDate().getValue().toString());
    }

    @Test
    public void cardNumberContainsLetters() {
        UnvalidatedCard card = new UnvalidatedCard("American Express", "abcd-abcd-abcd-abcd", "12/3030");
        Either<CardValidationError, ValidCard> result = cardValidaton.validate(card);
        assertTrue(result.isLeft());
        assertEquals(CardValidationError.class, result.getLeft().getErrorType());
        assertEquals("must only contain numerical digits separated by dash characters", result.getLeft().getErrorMesssage());
        assertEquals("cardNumber", result.getLeft().getFieldName());
        assertEquals("abcd-abcd-abcd-abcd", result.getLeft().getFieldValue());
    }

    @Test
    public void cardNumberInvalidGroupings() {
        UnvalidatedCard noGroupsCard = new UnvalidatedCard("American Express", "12341234123241234", "01/12/3030");
        Either<CardValidationError, ValidCard> noGroupsResult = cardValidaton.validate(noGroupsCard);
        assertEquals("cardNumber", noGroupsResult.getLeft().getFieldName());

        UnvalidatedCard improperGroupsCard = new UnvalidatedCard("American Express", "12-3412-3412-34-12", "01/12/3030");
        Either<CardValidationError, ValidCard> improperGroupsResult = cardValidaton.validate(improperGroupsCard);
        assertEquals("cardNumber", noGroupsResult.getLeft().getFieldName());
    }
}