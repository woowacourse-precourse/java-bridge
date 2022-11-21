package bridge;

import bridge.controller.BridgeGame;
import bridge.util.Message;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.createBridge();
        int count = 0;
        boolean success = false;
        do {
            int position = 0;
            count++;
            while (!bridgeGame.complete(position) && bridgeGame.move(position)) {
                position++;
            }
            if (bridgeGame.complete(position)) {
                success = true;
                break;
            }
        } while (bridgeGame.retry());
        if (success) {
            bridgeGame.gameExit(Message.SUCCESS_MESSAGE, count);
        }
        if (!success) {
            bridgeGame.gameExit(Message.FAIL_MESSAGE, count);
        }
    }
}
