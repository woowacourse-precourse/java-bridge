package bridge.domain;

import bridge.Enum.Error;
import bridge.Enum.PlayerInput;

public class DirectionInput {
    private final String direction;

    public DirectionInput(String input){
        isDirectionValid(input);
        this.direction = input;
    }
    public String getDirectionInput(){
        return direction;
    }
    public void isDirectionValid(String direction) {
        if (!direction.equals(PlayerInput.UP.getValue()) && !direction.equals(PlayerInput.DOWN.getValue())) {
            throw new IllegalArgumentException(Error.INPUT_DIRECTION.getMessage());
        }
    }
}
