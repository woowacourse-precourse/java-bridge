package bridge;

import bridge.controller.BridgeGameController;

public class Application {

    private static final BridgeNumberGenerator numberGenerator= new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker= new BridgeMaker(numberGenerator);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController gameController = new BridgeGameController();

        gameController.setBridge(bridgeMaker.makeBridge(gameController.getBridgeSize()));
        gameController.start();
    }

}