package bridge;

import bridge.controller.BridgeGameController;
import bridge.controller.BridgeMakerController;
import bridge.service.BridgeMakerService;
import bridge.service.BridgeGameService;

public class Application {

    public static void main(String[] args) {
        BridgeGamePlay bridgeGamePlay = new BridgeGamePlay();
        bridgeGamePlay.gamePlay();
    }
}
