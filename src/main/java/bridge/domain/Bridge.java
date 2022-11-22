package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bridge {

    private final int size;
    private final List<String> bridges;
    private final List<String> playerMovingHistory;

    public Bridge(int size, List<String> bridges) {
        this.size = size;
        this.bridges = bridges;
        this.playerMovingHistory = new ArrayList<>();
    }

    public boolean updateMoving(String moving) {
        playerMovingHistory.add(moving);
        return bridges.get(currentLocation()).equals(moving);
    }

    private int currentLocation() {
        return playerMovingHistory.size() - 1;
    }

    public boolean reachEndOfBridge() {
        return playerMovingHistory.size() == size;
    }

    public void clearPlayerMovingHistory() {
        this.playerMovingHistory.clear();
    }

    public List<String> getPlayerMovingHistory() {
        return Collections.unmodifiableList(playerMovingHistory);
    }
}
