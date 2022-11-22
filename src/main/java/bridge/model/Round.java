package bridge.model;

public class Round {
    private final Bridge bridge;

    private int position;
    private boolean isRightSpace;

    public Round(Bridge bridge) {
        this.bridge = bridge;
        this.position = 0;
        isRightSpace = true;
    }

    public void reset() {
        position = 0;
        isRightSpace = true;
    }

    public Movable canMovable(String selectedSpace) {
        Movable movable = bridge.compareSpace(position, selectedSpace);

        isRightSpace = movable.isMovable();

        return movable;
    }

    public void next() {
        position += 1;
    }

    public boolean isSuccessSelectingRightSpace() {
        return isRightSpace;
    }

    public boolean isSuccessLastRound() {
        return bridge.isEndOfBridge(position) && isRightSpace;
    }
}