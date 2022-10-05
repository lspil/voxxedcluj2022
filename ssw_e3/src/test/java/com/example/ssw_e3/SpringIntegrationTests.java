package com.example.ssw_e3;

import com.example.ssw_e3.controllers.DemoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringIntegrationTests {

  @Autowired
  private DemoController demoController;

  @Test
  @WithMockUser(authorities = "read")
  void testDemoA() {
    String value = demoController.demoA();

    assertEquals("Demo A", value);
  }

}
