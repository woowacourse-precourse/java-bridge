package bridge.view;

import bridge.domain.ExceptionMessage;
import bridge.domain.MovingStatus;

public class InputValidator {
   static final int START_LENGTH_RANGE = 3;
   static final int END_LENGTH_RANGE = 20;

    public void validateInputLength(String inputLength) {
        if (!isNumber(inputLength)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER);
        }
        if(!isInRange(inputLength)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_IN_RANGE);
        }
    }

    private boolean isNumber(String inputLength){
        return inputLength.matches("^[0-9]*$");
    }

    private boolean isInRange(String inputLength){
        int bridgeLength = Integer.parseInt(inputLength);
        return bridgeLength >= START_LENGTH_RANGE && bridgeLength <= END_LENGTH_RANGE;
    }

    public void validateMoving(String moving){
        if(!isUpOrDown(moving)){
            throw new IllegalArgumentException(ExceptionMessage.NOT_UP_OR_DOWN);
        }
    }

    private boolean isUpOrDown(String moving){
        return moving.equals(MovingStatus.UP.getMovingKey())
                || moving.equals(MovingStatus.DOWN.getMovingKey());
    }
}
