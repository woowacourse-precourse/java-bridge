package bridge.domain.bridgeGame.gameStatus;

public class Distance {
    private final static int INIT_DISTANCE = 0;

    private int distance;

    private Distance(int distance) {
        this.distance = distance;
    }

    public static Distance initDistance() {
        return new Distance(INIT_DISTANCE);
    }

    public void increaseDistance() {
        distance++;
    }

    public void reset() {
        distance = INIT_DISTANCE;
    }

    public int toInt() {
        return distance;
    }
}
