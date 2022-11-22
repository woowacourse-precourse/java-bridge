package bridge;

import bridge.view.utils.ConsoleUtils;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGameStarter bridgeGameStarter = new BridgeGameStarter(bridgeGame, bridgeMaker);

        ConsoleUtils.printGameStart();
        bridgeGameStarter.start();
    }
}
