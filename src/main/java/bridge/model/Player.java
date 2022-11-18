package bridge.model;

public class Player {
    private static int currentLocation;

    public Player() {
        currentLocation = -1;
    }

    public void moveStraight() {
        this.currentLocation += 1;
    }

    public static int getCurrentLocation() {
        return currentLocation;
    }

}
