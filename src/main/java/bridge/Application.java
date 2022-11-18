package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.Bridges;
import bridge.domain.GameState;
import bridge.service.BridgeGame;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController controller = new BridgeGameController(bridgeGame());
        controller.start();
    }

    private static BridgeGame bridgeGame() {
        return new BridgeGame(bridgeMaker(), bridges(), result());
    }

    private static BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    private static BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    private static Bridges bridges() {
        return new Bridges();
    }

    private static GameState result() {
        return new GameState();
    }
}
