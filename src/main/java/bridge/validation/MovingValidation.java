package bridge.validation;

import bridge.Message.ErrorMessage;

public class MovingValidation implements Validation{
    private static final String up = "U";
    private static final String down = "D";

    @Override
    public void validate(String value) {
        isUpOrDown(value);
    }

    private void isUpOrDown(String move){
        if(!(move.equals(up) || move.equals(down))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MOVE_VALID_STRING.getMessage());
        }
    }
}
