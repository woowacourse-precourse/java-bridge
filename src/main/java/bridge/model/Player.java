package bridge.model;

import bridge.util.Rules;

public class Player {
    private int playerPosition;

    public Player() {
        initPosition();
    }

    public void initPosition() {
        playerPosition = Rules.PLAYER_START_POSITION;
    }

    public int nextStep() {
        return (playerPosition = playerPosition + 1);
    }
}
