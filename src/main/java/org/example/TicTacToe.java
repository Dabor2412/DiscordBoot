package org.example;

import org.javacord.api.DiscordApi;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class TicTacToe implements MessageCreateListener {
    final private byte[][] spielfeld = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    private DiscordApi api;
    private String[] player;
    private int state = 0;
    /*
    0 = Wartet auf Namen
    1 = Spieler 1 ist am Zug
    2 = Spieler 2 ist am Zug
    */

    @Override
    public void onMessageCreate(MessageCreateEvent messageCreateEvent) {
        System.out.println(messageCreateEvent.getMessageAuthor().getDisplayName());
        if (messageCreateEvent.getMessageAuthor().getDisplayName().equals("DiscortBoot")) {
            System.out.println("WARUM BIST DU NICHT HIER?!?!?!?!?!");
            return;
        }
        if (this.state == 0) {
            this.state++;

            String[] messageContent = messageCreateEvent.getMessageContent().split(" ");
            if (messageContent.length != 2) {
                messageCreateEvent.getChannel().sendMessage("Da stimmt etwas nicht mit der Syntax.");
            }
            this.player = messageContent;

            messageCreateEvent.getChannel().sendMessage(this.player[0] + " spielt gegen " + this.player[1] + ".");
            System.out.println("Test");
            messageCreateEvent.getChannel().sendMessage(createAusgabeSpielfeld());
        }
    }

    private String createAusgabeSpielfeld() {
        String output = player[state-1] + " ist am Zug\n";

        output += "---------\n" +
                "|" + this.spielfeld[0][0] + "|" + this.spielfeld[1][0] + "|" + this.spielfeld[2][0] + "|\n" +
                "|" + this.spielfeld[0][1] + "|" + this.spielfeld[1][1] + "|" + this.spielfeld[2][1] + "|\n" +
                "|" + this.spielfeld[0][2] + "|" + this.spielfeld[1][2] + "|" + this.spielfeld[2][2] + "|\n";


        return output;
    }

    public TicTacToe(DiscordApi api) {
        this.api = api;

    }
}
