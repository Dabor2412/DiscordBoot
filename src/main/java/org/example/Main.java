package org.example;

import org.javacord.api.*;
import org.javacord.api.entity.intent.Intent;


public class Main {
    public static void main(String[] args) {
        // Insert your bot's token here
        String token = "MTA0Mjc5MjQxOTk4MjMxMTQzNQ.GPiS-c.3dtJR0_YS6F04oyx_IiBRDg6erGs5Jv_sBTKiY";

        DiscordApi api = new DiscordApiBuilder().setToken(token).addIntents(Intent.MESSAGE_CONTENT).login().join();

        // Add a listener
        StartingListener startingListener = new StartingListener(api);
        api.addListener(startingListener);

        // Print the invite url of your bot
        System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }
}