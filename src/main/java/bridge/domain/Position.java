package bridge.domain;

import java.util.Objects;

public class Position {
    private int distance;
    private String verticalStatus;

    private Position(int distance, String verticalStatus) {
        this.distance = distance;
        this.verticalStatus = verticalStatus;
    }
    public static Position of(int distance, String verticalStatus) {
        return new Position(distance, verticalStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return distance == position.distance && Objects.equals(verticalStatus, position.verticalStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance, verticalStatus);
    }
}
