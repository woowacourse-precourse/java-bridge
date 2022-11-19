package bridge;

import java.util.List;

public class BridgeGameView {
    BridgeGame bridgeGame = new BridgeGame();
    String bridgeGameUpResult = "[";
    String bridgeGameDownResult = "[";

    public void printBridgeResult(boolean isMoving, String moving) {
        String movingResult = "";

        if (!bridgeGameUpResult.equals("[")) {
            bridgeGameUpResult += "|";
            bridgeGameDownResult += "|";
        }

        if (isMoving) {
            movingResult = " O ";
        } else {
            movingResult = " X ";
        }

        if (moving.equals("U")) {
            bridgeGameUpResult += movingResult;
            bridgeGameDownResult += "   ";
        } else {
            bridgeGameUpResult += "   ";
            bridgeGameDownResult += movingResult;
        }

        System.out.println(bridgeGameUpResult+"]");
        System.out.println(bridgeGameDownResult+"]");
    }
}
