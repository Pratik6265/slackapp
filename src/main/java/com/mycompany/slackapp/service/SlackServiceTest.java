package com.mycompany.slackapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SlackServiceTest {


    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private SlackService slackService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendMessage() {
        // Arrange
        String message = "Hello, Slack!";
        String payload = String.format("{\"text\":\"%s\"}", message);
        when(restTemplate.postForObject(anyString(), any(), any(Class.class))).thenReturn(null);

        // Act
        slackService.sendMessage(message);

        // Assert
        verify(restTemplate).postForObject(anyString(), any(), any(Class.class));
    }
}
