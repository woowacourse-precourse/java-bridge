package bridge.domain.player;

public class MovedDistance {

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

    public int toInt() {
        return distance;
    }

    public boolean isSameAs(int distance) {
        return this.distance == distance;
    }
}
