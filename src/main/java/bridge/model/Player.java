package bridge.model;

public class Player {
    private int currentLocation;

    public Player() {
        currentLocation = 0;
    }

    public void moveStraight() {
        this.currentLocation += 1;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

}
