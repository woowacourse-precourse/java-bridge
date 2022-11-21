package bridge.Controller;

import bridge.Domain.BridgeSizeValidator;
import bridge.Domain.MoveValidator;
import bridge.Domain.RestartValidator;
import bridge.View.InputView;

public class InputController {
    public int setBridgeSize() {
        try {
            BridgeSizeValidator validator = new BridgeSizeValidator(InputView.readBridgeSize());
            return validator.getBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setBridgeSize();
        }
    }

    public String setMove() {
        try {
            MoveValidator validator = new MoveValidator(InputView.readMove());
            return validator.getMove();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setMove();
        }
    }

    public String setRestart() {
        try {
            RestartValidator validator = new RestartValidator(InputView.readGameCommand());
            return validator.getRestartWord();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setRestart();
        }
    }
}
