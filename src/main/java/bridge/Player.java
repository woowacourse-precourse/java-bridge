package bridge;

public class Player {
    private int currentLocation;
    private int countOfTry;

    Player () {
        this.countOfTry = 1;
        this.currentLocation = -1;
    }

    public void move() {
        currentLocation++;
    }

    public int getCurrentLocation() {
        return Integer.valueOf(currentLocation);
    }

    public int getCountOfTry() {
        return countOfTry;
    }

    public void retry() {
        currentLocation = -1;
        countOfTry++;
    }
}
