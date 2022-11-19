package bridge;

public class Player {
    int currentPosition;

    public Player() {
        currentPosition = -1;
    }

    public void moveForward() {
        currentPosition++;
    }
}
