package bridge;

import bridge.controller.GameController;

public class Application {

    private static final BridgeNumberGenerator bridgeNumberGenerator= new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker= new BridgeMaker(bridgeNumberGenerator);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();

        gameController.setBridge(bridgeMaker.makeBridge(gameController.getBridgeSize()));
        gameController.start();
    }
}