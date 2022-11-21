package bridge.domain;

import java.util.Objects;

import static bridge.viewer.MoveCommand.DOWN;
import static bridge.viewer.MoveCommand.UP;

public class Position {
    private final String position;

    private Position(String position) {
        this.position = position;
    }
    public static Position of(String position) {
        return new Position(position);
    }

    public boolean isUp() {
        return position.equals(UP);
    }
    public boolean isDown() {
        return position.equals(DOWN);
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
