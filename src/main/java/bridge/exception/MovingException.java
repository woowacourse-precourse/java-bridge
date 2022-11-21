package bridge.exception;

import bridge.service.UserInput;

public class MovingException extends UserException {
    @Override
    public void checkException(String userInput) {
        isEmpty(userInput);
        isBlank(userInput);
        hasBlank(userInput);
        isNotMoving(userInput);
    }

    private void isNotMoving(String moving) {
        if (!UserInput.MOVING.getLetters().contains(moving)) {
            throw new IllegalArgumentException(ExceptionCode.IS_NOT_MOVING.getMessage());
        }
    }
}
