package com.maxoptra.kwelsh;

import com.maxoptra.kwelsh.model.*;
import com.maxoptra.kwelsh.model.card.UnvalidatedCard;
import com.maxoptra.kwelsh.model.errors.CardError;
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
    private final CardRegistration cardRegistration;

    public CardController(@Autowired CardRegistration cardRegistration) {
        this.cardRegistration = cardRegistration;
    }

    @PostMapping("api/registerCard")
    public ResponseEntity<RegisterCardResponse> registerCard(@RequestBody RegisterCardRequest request) {
        Either<? extends CardError, ValidCard> result = cardRegistration.register(UnvalidatedCard.fromRequest(request));
        return new ResponseEntity<>(new RegisterCardSuccessResponse(result.get()), HttpStatus.OK);
    }
}
