package bridge.domain;

import java.util.List;

public class Player {

    private final List<String> map;
    private int gameAttempts;

    public Player(List<String> map, int gameAttempts) {
        this.map = map;
        this.gameAttempts = gameAttempts;
    }

    public void move(String moving) {
        map.add(moving);
    }

    private void rollbackLastMoved() {
        int lastMovedPosition = getLastMovedPosition();
        if (lastMovedPosition == -1) {
            return;
        }
        map.remove(lastMovedPosition);
    }

    private int getLastMovedPosition() {
        return map.size() - 1;
    }
}
