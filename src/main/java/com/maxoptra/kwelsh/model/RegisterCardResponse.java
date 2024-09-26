package com.maxoptra.kwelsh.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterCardResponse {
    private String bankName;
    private String cardNumber;
    private String expiryDate;
}
