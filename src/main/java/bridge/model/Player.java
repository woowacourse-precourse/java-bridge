package bridge.model;

public class Player {
    private int position;
    private int retryCount;

    public Player() {
        initialize();
    }

    public void initialize() {
        position = 0;
        retryCount++;
    }

    public MoveResult move(Bridge bridge, Direction direction) {
        if (bridge.isMovable(position++, direction)) {
            return new MoveResult(DrawType.SUCCESS, direction);
        }
        return new MoveResult(DrawType.FAIL, direction);
    }

    public boolean moveToEnd(Bridge bridge) {
        return bridge.end(position);
    }

    public int getRetryCount() {
        return retryCount;
    }
}
