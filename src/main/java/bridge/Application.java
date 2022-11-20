package bridge;

import bridge.controller.GamePlayController;

public class Application {

    public static void main(String[] args) {
//        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
//        List<String> strings = bridgeMaker.makeBridge(5);
//        System.out.println(strings);

        GamePlayController gamePlayController = new GamePlayController();
        gamePlayController.createBridgeGame();
    }
}
