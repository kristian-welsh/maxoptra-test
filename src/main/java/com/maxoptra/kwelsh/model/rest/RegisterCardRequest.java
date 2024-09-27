package com.maxoptra.kwelsh.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterCardRequest {
    private String bankName;
    private String cardNumber;
    private String expiryDate;
}
