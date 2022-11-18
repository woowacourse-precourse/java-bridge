package bridge;

import bridge.game.BridgeGameMachine;

public class Application {
    public static void main(String[] args) {
        BridgeGameMachine bridgeGameMachine = new BridgeGameMachine();
        bridgeGameMachine.setGame();
        bridgeGameMachine.playGame();
        while (bridgeGameMachine.askRetry()) {
            bridgeGameMachine.retry();
        }
        bridgeGameMachine.printResult();
    }
}
