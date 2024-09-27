package com.maxoptra.kwelsh;

import com.jayway.restassured.RestAssured;
import com.maxoptra.kwelsh.model.rest.RegisterCardRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class CardControllerIntegrationTest {
    @Value("${local.server.port}")
    private int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void registerCardSuccessfully() {
        RegisterCardRequest requestBody = new RegisterCardRequest("amex", "3700-0000-0000-0000", "01/3030");
        given().body(requestBody)
                .header("Content-Type", "application/json; charset=utf8")
                .post("/api/registerCard")
                .then()
                .body(is("{\"successful\":true,\"card\":{\"bankName\":{\"value\":\"amex\"},\"cardNumber\":{\"value\":\"xxxx-xxxx-xxxx-0000\"},\"expiryDate\":{\"value\":\"3030-01-01\"}}}"));
    }

    @Test
    public void registerCardUnsuccessfully() {
        RegisterCardRequest requestBody = new RegisterCardRequest("amex", "000000000000---0000", "01/3030");
        given().body(requestBody)
                .header("Content-Type", "application/json; charset=utf8")
                .post("/api/registerCard")
                .then()
                .body(is("{\"successful\":false,\"error\":{\"errorType\":\"com.maxoptra.kwelsh.model.errors.CardValidationError\",\"errorMesssage\":\"must only contain numerical digits separated by dash characters\",\"fieldName\":\"cardNumber\",\"fieldValue\":\"000000000000---0000\"},\"card\":{\"bankName\":\"amex\",\"cardNumber\":\"xxxx-xxxx-xxxx-0000\",\"expiryDate\":\"01/3030\"}}"));
    }
}
