package bridge;

public class Player {
    private int currentLocation;
    private int countOfTry;

    Player () {
        this.countOfTry = 1;
        this.currentLocation = 0;
    }

    public void move() {
        currentLocation++;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public int getCountOfTry() {
        return countOfTry;
    }

    public void retry() {
        currentLocation = 0;
        countOfTry++;
    }
}
