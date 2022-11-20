package bridge;

public class Player {
    private final int START_POSITION = -1;
    int currentPosition;

    public Player() {
        currentPosition = START_POSITION;
    }

    public void move() {
        currentPosition++;
    }

    public int getNextPosition() {
        return currentPosition + 1;
    }
}
