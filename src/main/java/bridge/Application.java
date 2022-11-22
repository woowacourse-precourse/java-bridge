package bridge;

import bridge.controller.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.Player;
import bridge.service.BridgeService;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeService bridgeService = getBridgeService();
        BridgeGame bridgeGame = new BridgeGame(bridgeService);

        bridgeGame.startGame();
    }

    public static BridgeService getBridgeService() {
        return new BridgeService(getBridgeMaker());
    }

    public static BridgeMaker getBridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
