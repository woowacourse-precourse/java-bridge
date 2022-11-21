package bridge.view;

import bridge.vo.Commend;

public class Validator {

    public void inputSizeValidator(String size) {
        if(!size.matches("[0-9]+")){
            throwError(ErrorMessage.NOT_INTEGER_ERROR.getErrorMessage());
        }
    }

    public void validatorBridgeSizeRange(String size) {
        int len = Integer.parseInt(size);
        if(len < 1 || len > 20){
            throwError(ErrorMessage.BRIDGE_RANGE_ERROR.getErrorMessage());
        }
    }

    public void validateMoving(String moving) {
        if(!(moving.equals(Commend.UP) || moving.equals(Commend.DOWN))){
            throwError(ErrorMessage.DIRECTION_COMMEND_ERROR.getErrorMessage());
        }
    }

    public void validateRetryCommand(String command) {
        if(!(command.equals(Commend.RETRY) || command.equals(Commend.QUIT))){
            throwError(ErrorMessage.RETRY_COMMEND_ERROR.getErrorMessage());
        }
    }

    private void throwError(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }
}
