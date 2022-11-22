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
        String move = null;
        while (move == null) {
            move = validateGetMoving();
        }
        return new MoveSpace(move);
    }

    private static String validateGetMoving(){
        String move = null;
        try {
            move = InputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return move;
    }

    public static String retryOrGameOver() {
        if (InputView.readGameCommand().equals("R")) {
            return "R";
        }
        return "Q";
    }
}
