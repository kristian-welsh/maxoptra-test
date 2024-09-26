package com.maxoptra.kwelsh;

import com.maxoptra.kwelsh.model.*;
import com.maxoptra.kwelsh.model.card.UnvalidatedCard;
import com.maxoptra.kwelsh.model.errors.CardValidationError;
import com.maxoptra.kwelsh.validation.CardValidation;
import com.maxoptra.kwelsh.validation.model.ValidCard;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardController {
    private final CardValidation cardValidation;

    public CardController(@Autowired CardValidation cardValidation) {
        this.cardValidation = cardValidation;
    }

    @PostMapping("api/registerCard")
    public ResponseEntity<RegisterCardResponse> registerCard(@RequestBody RegisterCardRequest request) {
        UnvalidatedCard card = UnvalidatedCard.fromRequest(request);
        Either<CardValidationError, ValidCard> validationResult = cardValidation.validate(card);
        //todo: store card

        return new ResponseEntity<>(new RegisterCardSuccessResponse(card), HttpStatus.OK);
    }
}
