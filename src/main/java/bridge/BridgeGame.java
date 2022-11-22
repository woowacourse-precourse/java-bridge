package bridge;

import bridge.controller.GameController;
import bridge.model.Moving;
import bridge.model.ReEnter;

public class BridgeGame {
    private final static String RE_START = "R";

    public static boolean move(String computer, String userInput) {
        return computer.equals(userInput);
    }

    public static boolean retry() {
        if (ReEnter.reGetExitOrRestart().equals(RE_START)) {
            Moving.clearMoving();
            return true;
        }
        GameController.printMovingAndResult();
        return false;
    }
}