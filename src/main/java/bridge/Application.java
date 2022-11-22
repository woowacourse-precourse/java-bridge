package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.facade.BridgeGameFacade;
import bridge.service.BridgeGame;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController controller = new BridgeGameController(bridgeGame());
        controller.start();
    }

    private static BridgeGame bridgeGame() {
        return new BridgeGame(bridgeMaker(), player(), facade());
    }

    private static BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    private static BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    private static Bridge bridge() {
        return new Bridge();
    }

    private static Player player() {
        return new Player();
    }

    private static BridgeGameFacade facade() {
        return new BridgeGameFacade(bridge(), player());
    }
}
