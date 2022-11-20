package bridge.domain.player;

public class MovedDistance {
    public final static int INIT_DISTANCE = 0;

    private final int distance;

    private MovedDistance(int distance) {
        this.distance = distance;
    }

    public static MovedDistance from(int distance) {
        return new MovedDistance(distance);
    }

    public MovedDistance increaseDistance() {
        return new MovedDistance(distance + 1);
    }

    public MovedDistance reset() {
        return new MovedDistance(INIT_DISTANCE);
    }

    public int toInt() {
        return distance;
    }

    public boolean isSameAs(int distance) {
        return this.distance == distance;
    }
}
