package bridge;

import java.util.List;

public class PlayerBridgeChoices {

    private final List<PlayerBridgeChoice> playerBridgeChoices;

    public PlayerBridgeChoices(List<PlayerBridgeChoice> playerBridgeChoices) {
        this.playerBridgeChoices = playerBridgeChoices;
    }

    public void addBridgeChoice(PlayerBridgeChoice playerBridgeChoice) {
        this.playerBridgeChoices.add(playerBridgeChoice);
    }

    public List<PlayerBridgeChoice> getPlayerBridgeChoices() {
        return this.playerBridgeChoices;
    }

}
