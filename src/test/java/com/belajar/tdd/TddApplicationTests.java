package com.belajar.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TddApplicationTests {

    @Test
    public void contextLoads() {
        TddApplication.main(new String[]{
                "--spring.main.web-environment=false",
                // Override any other environment properties according to your needs
        });
        Assertions.assertTrue(true);
    }

}
