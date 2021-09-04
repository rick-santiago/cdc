package com.cdc.provider;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProviderApplicationTests {

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(new ProviderApplication());
    }

}
