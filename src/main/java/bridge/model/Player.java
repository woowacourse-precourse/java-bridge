package bridge.model;

public class Player {
    private int position;
    private int tryCount;

    public Player() {
        initialize();
    }

    public void initialize() {
        position = 0;
        tryCount++;
    }

    public boolean move(Bridge bridge, Direction direction) {
        return bridge.isMovable(position++, direction);
    }

    public boolean moveToEnd(Bridge bridge) {
        return bridge.end(position);
    }

    public int getTryCount() {
        return tryCount;
    }
}
