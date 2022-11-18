package bridge.domain;

public class Position {
    private int position = -1;
    private final int bridgeSize;

    public Position(int size) {
        this.bridgeSize = size;
    }

    public int getNext() {
        return ++position;
    }

    public void clear() {
        this.position = -1;
    }
    public void fail() {
        this.position = -2;
    }
    public int getPosition() {
        return position;
    }

    public boolean isDone() {
        return position == bridgeSize - 1;
    }

    public boolean isLessThanBridgeLength() {
        return position < bridgeSize - 1;
    }

    public boolean isNotInitializedValue() {
        return position != -2;
    }

}
