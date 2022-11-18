package bridge.model;

public class Player {
    public static int currentLocation;

    public Player() {
        currentLocation = -1;
    }

    public void moveStraight() {
        currentLocation += 1;
    }
}
