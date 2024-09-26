package com.maxoptra.kwelsh;

import com.maxoptra.kwelsh.model.RegisterCardRequest;
import com.maxoptra.kwelsh.model.RegisterCardResponse;
import com.maxoptra.kwelsh.model.RegisterCardSuccessResponse;
import com.maxoptra.kwelsh.model.UnvalidatedCard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardController {
    @PostMapping("api/registerCard")
    public ResponseEntity<RegisterCardResponse> registerCard(@RequestBody RegisterCardRequest request) {
        UnvalidatedCard card = UnvalidatedCard.fromRequest(request);
        //todo: validate card
        return new ResponseEntity<>(new RegisterCardSuccessResponse(card), HttpStatus.OK);
    }
}
