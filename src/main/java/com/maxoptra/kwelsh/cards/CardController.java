package com.maxoptra.kwelsh.cards;

import com.maxoptra.kwelsh.model.UnvalidatedCard;
import com.maxoptra.kwelsh.model.errors.CardError;
import com.maxoptra.kwelsh.model.rest.RegisterCardFailureResponse;
import com.maxoptra.kwelsh.model.rest.RegisterCardRequest;
import com.maxoptra.kwelsh.model.rest.RegisterCardResponse;
import com.maxoptra.kwelsh.model.rest.RegisterCardSuccessResponse;
import com.maxoptra.kwelsh.validation.model.ValidCard;
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
        UnvalidatedCard card = UnvalidatedCard.fromRequest(request);
        //noinspection Convert2MethodRef - i prefer either all method-refs or no method-refs
        return cardRegistration.register(card)
                .map(validCard -> registrationSuccess(validCard))
                .getOrElseGet(error -> registrationFailure(error, card));
    }

    private static ResponseEntity<RegisterCardResponse> registrationSuccess(ValidCard card) {
        return new ResponseEntity<>(new RegisterCardSuccessResponse(card), HttpStatus.OK);
    }

    private static ResponseEntity<RegisterCardResponse> registrationFailure(CardError error, UnvalidatedCard card) {
        return new ResponseEntity<>(new RegisterCardFailureResponse(error, card), HttpStatus.BAD_REQUEST);
    }
}
