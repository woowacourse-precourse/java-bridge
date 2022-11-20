package bridge;

public class Position {
    private int position = -1;
    private final int bridgeSize;

    Position(int size) {
        this.bridgeSize = size;
    }

    int getNext() {
        return position++;
    }

    void clear() {
        this.position = -1;
    }

    void fail() {
        this.position = -2;
    }

    int getPosition() {
        return position;
    }

    boolean arrive() {
        return position == bridgeSize -1;
    }

    boolean isNotArrive() {
        return position < bridgeSize -1;
    }

    boolean isNotReset() {
        return position != -2;
    }
}
