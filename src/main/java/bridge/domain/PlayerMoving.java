package bridge.domain;

import bridge.enums.MovingType;

public class PlayerMoving {
    private String moving;

    public PlayerMoving(String input) {
        input = input.strip();
        validateMovingType(input);
        this.moving = input;
    }

    private void validateMovingType(String moving) throws IllegalArgumentException{
        MovingType.selectMovingTypeByInitial(moving);
    }

    public String getMoving() {
        return moving;
    }
}
