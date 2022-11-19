package bridge.domain;

import java.util.Objects;

public class Position {
    private final String position;

    private Position(String position) {
        this.position = position;
    }
    public static Position of(String position) {
        return new Position(position);
    }

    public boolean isUp() {
        return position.equals("U");
    }
    public boolean isDown() {
        return position.equals("D");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
