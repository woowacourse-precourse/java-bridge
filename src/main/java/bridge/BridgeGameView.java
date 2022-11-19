package bridge;

import java.util.List;

public class BridgeGameView {
    BridgeGame bridgeGame = new BridgeGame();
    String bridgeGameResult = "[";

    public void printBridgeResult(boolean isMoving) {
        if (!bridgeGameResult.equals("[")) {
            bridgeGameResult += "|";
        }

        if (isMoving) {
            bridgeGameResult += " O ";
        } else {
            bridgeGameResult += " X ";
        }

        System.out.println(bridgeGameResult+"]");
    }
}
