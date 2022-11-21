package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<String> playerMoving;

    public Player() {
        playerMoving = new ArrayList<>();
    }

    public void movePlayer(String moving) {
        playerMoving.add(moving);
    }

    public List<String> getPlayerMoving() {
        return playerMoving;
    }

    public void clearMoving() {
        playerMoving.clear();
    }
}
