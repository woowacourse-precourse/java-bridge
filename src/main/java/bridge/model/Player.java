package bridge.model;

public class Player {
    public static int currentLocation;

    public Player() {
        initCurrentLocation();
    }

    public void moveForward() {
        currentLocation += 1;
    }

    public void initCurrentLocation() {
        currentLocation = -1;
    }
}
