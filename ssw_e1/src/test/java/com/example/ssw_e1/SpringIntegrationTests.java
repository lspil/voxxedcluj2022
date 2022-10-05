package com.example.ssw_e1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringIntegrationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @WithMockUser
  void demoAWithAuthentication() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/demo/a")).andExpect(
        status().isOk()
    );
  }

  @Test
  void demoAWithoutAuthentication() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/demo/a")).andExpect(
        status().isUnauthorized()
    );
  }
}
