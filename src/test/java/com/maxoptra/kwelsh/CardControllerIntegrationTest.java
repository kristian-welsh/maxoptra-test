package com.maxoptra.kwelsh;

import com.jayway.restassured.RestAssured;
import com.maxoptra.kwelsh.model.RegisterCardRequest;
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
        RegisterCardRequest requestBody = new RegisterCardRequest("amex", "37", "01/01/3030");
        given().body(requestBody)
                .header("Content-Type", "application/json; charset=utf8")
                .post("/api/registerCard")
                .then()
                .body(is("{\"successful\":true,\"card\":{\"bankName\":\"amex\",\"cardNumber\":\"37\",\"expiryDate\":\"01/01/3030\"}}"));
    }
}
