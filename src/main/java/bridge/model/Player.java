package bridge.model;

import java.util.List;

public class Player {
    private final List<Moving> history;

    public Player(List<Moving> history) {
        this.history = history;
    }

    public PlayerStatus move(Moving choice, Bridges bridges) {
        history.add(choice);
        return bridges.acceptPlayer(nextLocation(), choice);
    }

    private int nextLocation() {
        return history.size();
    }
}
