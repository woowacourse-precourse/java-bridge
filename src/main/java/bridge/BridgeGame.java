package bridge;

import bridge.controller.GameController;
import bridge.model.Moving;
import bridge.model.ReEnter;

public class BridgeGame {

    public static boolean move(String computer, String userInput) {
        return computer.equals(userInput);
    }

    public static boolean retry() {
        if (ReEnter.reGetExitOrRestart().equals("R")) {
            Moving.clearMoving();
            return true;
        }
        GameController.printMovingAndResult();
        return false;
    }
}