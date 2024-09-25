package com.maxoptra.kwelsh;

import com.jayway.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class HelloControllerTest {
    @Value("${local.server.port}")
    int port;

    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void testHello() {
        when().get("/").then()
                .body(is("Hello World!"));
    }

    @Test
    public void testCalc() {
        given().param("left", 100)
                .param("right", 200)
                .get("/calc")
                .then()
                .body(is("300"));
    }
}
