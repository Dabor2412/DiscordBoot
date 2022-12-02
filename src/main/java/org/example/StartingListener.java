package org.example;

import org.javacord.api.DiscordApi;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class StartingListener implements MessageCreateListener {
    private DiscordApi api;


    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equals("!help")) {
            event.getChannel().sendMessage("!TTT --> TicTacToe");
        } else if (event.getMessageContent().equals("!TTT")) {
            event.getChannel().sendMessage("Gib bitte die zwei Spielernamen getrennt von einem Leerzeichen an.");
            api.removeListener(this);
            api.addMessageCreateListener(new TicTacToe(this.api));
        }
    }

    public StartingListener(DiscordApi api) {
        this.api = api;
    }
}
