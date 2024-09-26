package com.maxoptra.kwelsh;

import com.maxoptra.kwelsh.model.RegisterCardRequest;
import com.maxoptra.kwelsh.model.RegisterCardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
    @PostMapping("api/registerCard")
    ResponseEntity<RegisterCardResponse> registerCard(@RequestBody RegisterCardRequest request) {
        return new ResponseEntity<>(
                new RegisterCardResponse(
                        request.getBankName(),
                        request.getCardNumber(),
                        request.getExpiryDate()),
                HttpStatus.OK);
    }
}
