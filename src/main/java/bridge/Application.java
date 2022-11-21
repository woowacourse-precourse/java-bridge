package bridge;

import bridge.controller.BridgeGameController;
import bridge.model.SuccessOrFail;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.createBridge();
        int count = 0;
        boolean complete = false;
        do {
            int position = 0;
            count++;
            while (!bridgeGameController.complete(position) && bridgeGameController.moveControl(position)) {
                position++;
            }
            if (bridgeGameController.complete(position)) {
                complete = true;
                break;
            }
        } while (bridgeGameController.retryControl());
        bridgeGameController.gameExit(SuccessOrFail.getSuccessOrFailMessage(complete), count);
    }
}
