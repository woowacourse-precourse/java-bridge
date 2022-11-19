package bridge;

public class Player {
    private final int START_POSITION = -1;
    int currentPosition;

    public void moveForward() {
        currentPosition++;
    }

    public void initializePosition() {
        currentPosition = START_POSITION;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
