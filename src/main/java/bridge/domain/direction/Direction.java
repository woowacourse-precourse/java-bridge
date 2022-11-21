package bridge.domain.direction;

import java.util.Objects;

public class Direction {

    public static final String UPWARD_DIRECTION = "U";
    public static final String DOWNWARD_DIRECTION = "D";
    private final String direction;

    public Direction(String direction) {
        validateForm(direction);
        this.direction = direction;
    }

    private void validateForm(String direction) {
        if(!direction.matches("[UD]")) {
            throw new IllegalArgumentException("[ERROR] U 혹은 D만 입력할 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Direction direction1 = (Direction) o;
        return direction.equals(direction1.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }

    @Override
    public String
    toString() {
        return "Direction{" +
                "direction=\"" + direction + '\"' +
                '}';
    }
}
