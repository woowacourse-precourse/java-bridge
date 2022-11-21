package bridge.model;

public class BridgeGame {

    public void move(final Player player, final String choice) {
        player.addChoice(choice);
    }

    public void retry(final Player player) {
        player.resetChoices();
        player.addTryCount();
    }

}