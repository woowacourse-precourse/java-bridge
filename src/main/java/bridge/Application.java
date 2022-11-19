package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.Bridges;
import bridge.domain.Player;
import bridge.domain.Result;
import bridge.service.BridgeGame;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController controller = new BridgeGameController(bridgeGame());
        controller.start();
    }

    private static BridgeGame bridgeGame() {
        return new BridgeGame(bridgeMaker(), bridges(), player(), result());
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

    private static Player player() {
        return new Player();
    }

    private static Result result() { return new Result(); }
}
