# Slack Message Sender Application

This is a Spring Boot application that sends messages to a Slack channel using Slack's Incoming Webhooks.

## Table of Contents

- [Project Setup](#project-setup)
- [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [Slack Incoming Webhook Setup](#slack-incoming-webhook-setup)
- [Testing](#testing)

## Project Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/YourUsername/slackapp.git
   cd slackapp

2. Open the project in your preferred IDE.

3. Ensure you have Java 11 or 17 and Maven installed on your system.

4. Add the Slack Webhook URL to the application.properties file:

5. Open src/main/resources/application.properties and add your Slack Webhook URL: slack.webhook.url=YOUR_SLACK_WEBHOOK_URL_HERE

Project Structure



slackapp
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── slackapp
│   │   │               ├── SlackAppApplication.java
│   │   │               ├── controller
│   │   │               │   ├── SlackController.java
│   │   │               │   └── MessageRequest.java
│   │   │               └── service
│   │   │                   └── SlackService.java
│   ├── resources
│   │   └── application.properties
└── test
    └── java
        └── com
            └── example
                └── slackapp
                    ├── SlackAppApplicationTests.java
                    ├── service
                    │   └── SlackServiceTest.java
                    └── controller
                        └── SlackControllerIntegrationTest.java





Brief Description and Development Decisions

-> SlackService: This service class is responsible for sending messages to Slack. It uses RestTemplate to make HTTP POST requests to the Slack Incoming Webhook URL.
-> SlackController: This controller class exposes the /sendSlackMessage endpoint, which accepts a JSON payload containing the message to be sent to Slack.
-> MessageRequest: This is a simple DTO class that encapsulates the message payload.
-> Tests: Unit tests for SlackService and integration tests for SlackController ensure the functionality is correctly implemented and tested.

Slack Incoming Webhook Setup
1. Create or Log In to Your Slack Workspace:
Go to Slack and either create a new workspace or log in to your existing workspace.

2. Create an Incoming Webhook:
-> Navigate to the Incoming Webhooks page on the Slack API site.
-> Click on "Create an App".
-> Enter an "App Name" and choose the workspace where you want to install the app. Click "Create App".

3. Enable Incoming Webhooks:
->In the app configuration page, find the "Incoming Webhooks" section and click "Activate Incoming Webhooks".

4. Add a New Webhook to Your Workspace:
-> Scroll down to the "Webhook URLs for Your Workspace" section and click "Add New Webhook to Workspace".
-> Select the channel you want to post messages to and click "Allow".
-> Copy the generated webhook URL. This URL will be used in your Spring Boot application.

5. Configure the Webhook URL in Your Application:
-> Open src/main/resources/application.properties and add your Slack Webhook URL: slack.webhook.url=YOUR_SLACK_WEBHOOK_URL_HERE

Testing
Unit Tests:
Unit tests for the SlackService are written using JUnit and Mockito. These tests verify that the service correctly formats the payload and sends the message to Slack.

Integration Tests:
Integration tests for the SlackController are written using Spring Boot's testing framework and MockMvc. These tests verify that the /sendSlackMessage endpoint correctly processes the request and calls the SlackService.
