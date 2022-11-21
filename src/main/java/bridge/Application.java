package bridge;

import bridge.controller.BridgeGame;
import bridge.model.SuccessOrFail;
import bridge.util.Message;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.createBridge();
        int count = 0;
        boolean complete = false;
        do {
            int position = 0;
            count++;
            while (!bridgeGame.complete(position) && bridgeGame.move(position)) {
                position++;
            }
            if (bridgeGame.complete(position)) {
                complete = true;
                break;
            }
        } while (bridgeGame.retry());
        bridgeGame.gameExit(SuccessOrFail.getSuccessOrFailMessage(complete), count);
    }
}
