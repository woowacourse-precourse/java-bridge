package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private PlayerStatus playerStatus;
    private final List<Moving> history;

    public Player() {
        playerStatus = PlayerStatus.MOVING;
        history = new ArrayList<>();
    }

    public PlayerStatus move(Moving choice, Bridge bridge) {
        history.add(choice);
        playerStatus = bridge.acceptPlayer(nextLocation(), choice);
        return playerStatus;
    }

    private int nextLocation() {
        return history.size() - 1;
    }

    public boolean isCrossedBridge() {
        return playerStatus == PlayerStatus.CROSSED;
    }

    public boolean isDead() {
        return playerStatus == PlayerStatus.DEAD;
    }

    public List<Moving> getHistory() {
        return history;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }
}
