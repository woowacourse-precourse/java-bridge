package bridge.controller;

import static bridge.view.SystemMessage.*;

import bridge.domain.Bridge;
import bridge.domain.MoveSpace;
import bridge.view.InputView;

public class InputController {

    public static Bridge getBridge() {
        return new Bridge(InputView.readBridgeSize());
    }

    public static MoveSpace getMoving() {
        MoveSpace moveSpace = null;
        while (moveSpace == null) {
            try {
                moveSpace = new MoveSpace(InputView.readMoving());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return moveSpace;
    }


    public static String getRetryOrGameOver() {
        return InputView.readGameCommand();

    }
}