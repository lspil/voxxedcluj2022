package com.example.ssw_e5_rs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SswE5RsApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testDemo() throws Exception {
    mockMvc.perform(
        MockMvcRequestBuilders.get("/demo")
            .with(SecurityMockMvcRequestPostProcessors.jwt().authorities(() -> "read"))
        )
        .andExpect(status().isOk());
  }

  @Test
  void testDemoWrongAuthority() throws Exception {
    mockMvc.perform(
            MockMvcRequestBuilders.get("/demo")
                .with(SecurityMockMvcRequestPostProcessors.jwt().authorities(() -> "write"))
        )
        .andExpect(status().isForbidden());
  }

}
