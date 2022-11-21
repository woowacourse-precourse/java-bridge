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

    public MoveResult move(Bridge bridge, Direction direction) {
        if (bridge.isMovable(position++, direction)) {
            return new MoveResult(DrawType.SUCCESS, direction);
        }
        return new MoveResult(DrawType.FAIL, direction);
    }

    public boolean moveToEnd(Bridge bridge) {
        return bridge.end(position);
    }

    public int getTryCount() {
        return tryCount;
    }
}
