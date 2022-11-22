package bridge.model;

public class Player {
    private int position;
    private int tryCount;

    public Player() {
        initialize();
    }

    public void initialize() {
        position = -1;
        tryCount++;
    }

    public void move() {
        position++;
    }

    public boolean die(Bridge bridge, Direction direction) {
        return bridge.isBroken(position, direction);
    }

    public boolean isBridgePassed(Bridge bridge) {
        return bridge.isEnded(position);
    }

    public int getTryCount() {
        return tryCount;
    }
}
