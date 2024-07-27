package com.mycompany.slackapp.controller;



import com.mycompany.slackapp.service.SlackService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SlackControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SlackService slackService;

    @Test
    void testSendSlackMessage() throws Exception {
        // Arrange
        String message = "Hello, Slack!";
        String jsonPayload = "{\"message\":\"" + message + "\"}";

        // Mock the SlackService
        Mockito.doNothing().when(slackService).sendMessage(message);

        // Act & Assert
        mockMvc.perform(post("/api/sendSlackMessage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk());

        // Verify that the service method was called
        Mockito.verify(slackService).sendMessage(message);
    }
}
