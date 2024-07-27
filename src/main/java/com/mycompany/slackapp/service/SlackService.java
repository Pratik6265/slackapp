package com.mycompany.slackapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SlackService {

    @Value("${slack.webhook.url}")
    private String slackWebhookUrl;

    private final RestTemplate restTemplate;

    public SlackService() {
        this.restTemplate = new RestTemplate();
    }

    public void sendMessage(String message) {
        String payload = String.format("{\"text\":\"%s\"}", message);
        restTemplate.postForObject(slackWebhookUrl, payload, String.class);
    }
}
