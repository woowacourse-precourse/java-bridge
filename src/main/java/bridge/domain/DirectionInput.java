package bridge.domain;

import bridge.Enum.Error;
import bridge.Enum.PlayerInput;

public class DirectionInput {
    private final String direction;

    public DirectionInput(String input){
        isDirectionValid(input);
        this.direction = input;
    }
    public void isDirectionValid(String direction) {
        if (!direction.equals(PlayerInput.UP) && !direction.equals(PlayerInput.DOWN)) {
            throw new IllegalArgumentException(Error.INPUT_DIRECTION.getMessage());
        }
    }
}
