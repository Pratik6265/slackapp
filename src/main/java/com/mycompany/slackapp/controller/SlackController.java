package com.mycompany.slackapp.controller;


import com.mycompany.slackapp.service.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SlackController {

    @Autowired
    private SlackService slackService;

    @PostMapping("/sendSlackMessage")
    public void sendSlackMessage(@RequestBody MessageRequest messageRequest) {
        slackService.sendMessage(messageRequest.getMessage());
    }
}
