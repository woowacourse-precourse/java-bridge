package bridge;

import java.util.InputMismatchException;

public class ValidateUserInput {
    public void checkBridgeSizeRange(String bridgeSize) {
        if(Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20)
            throw new NumberFormatException(ErrorCase.ERROR.getError() + ErrorCase.SIZE_ERROR.getError());
    }
    public void checkBridgeSizeIsDigit(String bridgeSize) {
        for(int i = 0; i < bridgeSize.length(); i++){
            if(!Character.isDigit(bridgeSize.charAt(i))) {
                throw new NumberFormatException(ErrorCase.ERROR.getError() + ErrorCase.SIZE_IS_DIGIT.getError());
            }
        }
    }
    public void checkReadMoving(String moveButton) {
        if(InputCase.UP.getInput().equals(moveButton) || InputCase.DOWN.getInput().equals(moveButton)) {
            return;
        }
        throw new InputMismatchException(ErrorCase.ERROR.getError() + ErrorCase.MOVE_ERROR.getError());
    }
    public void checkRestartCommand(String gameCommandButton) {
        if(InputCase.RESTART.getInput().equals(gameCommandButton) || InputCase.QUIT.getInput().equals(gameCommandButton)) {
            return;
        }
        throw new InputMismatchException(ErrorCase.RESTART_ERROR.getError() + ErrorCase.RESTART_ERROR.getError());
    }
}
