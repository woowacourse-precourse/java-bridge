package bridge.view;

import bridge.domain.ExceptionMessage;
import bridge.domain.MovingStatus;

public class InputValidator {
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
