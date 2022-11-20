package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Moving> history;

    public Player() {
        history = new ArrayList<>();
    }

    public PlayerStatus move(Moving choice, Bridge bridge) {
        history.add(choice);
        return bridge.acceptPlayer(nextLocation(), choice);
    }

    private int nextLocation() {
        return history.size() - 1;
    }

    public List<Moving> getHistory() {
        return history;
    }
}
