package bridge.Model.WrappingType;

import bridge.Enum.Direction;

public class ChoiceDirection {
    private Direction choiceDirection;

    public ChoiceDirection(String choiceDirection) {
        this.choiceDirection = validData(choiceDirection);
    }

    private Direction validData(String choiceDirection) {
        if (choiceDirection.equals(Direction.DOWN.getString())) {
            return Direction.DOWN;
        } else if (choiceDirection.equals(Direction.UP.getString())) {
            return Direction.UP;
        }
        throw new IllegalArgumentException("올바른 값을 입력해주세요");
    }

    public boolean compare(String directionString) {
        return choiceDirection.getString().equals(directionString);
    }

    public boolean compare(Direction direction) {
        return choiceDirection.equals(direction);
    }
}
