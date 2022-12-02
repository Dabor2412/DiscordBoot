package org.example;

import org.javacord.api.*;
import org.javacord.api.entity.intent.Intent;

import static org.example.Secrets.token;


public class Main {
    public static void main(String[] args) {
        // Insert your bot's token here
        DiscordApi api = new DiscordApiBuilder().setToken(token).addIntents(Intent.MESSAGE_CONTENT).login().join();

        // Add a listener
        StartingListener startingListener = new StartingListener(api);
        api.addListener(startingListener);

        // Print the invite url of your bot
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }
}