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

    public void retry() {
        rollbackLastMoved();
        increaseGameAttempts();
    }

    public int getMovingPosition() {
        return this.map.size();
    }

    public String getMovedResultByPosition(int position) {
        return this.map.get(position);
    }

    public String getLastMovedResult() {
        int lastMovedPosition = getLastMovedPosition();
        return getMovedResultByPosition(lastMovedPosition);
    }

    public int getGameAttempts() {
        return this.gameAttempts;
    }

    private void increaseGameAttempts() {
        gameAttempts++;
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
