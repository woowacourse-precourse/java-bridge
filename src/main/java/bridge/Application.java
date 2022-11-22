package bridge;

import bridge.game.BridgeGameMachine;

public class Application {
    public static void main(String[] args) {
        BridgeGameMachine bridgeGameMachine = new BridgeGameMachine();
        bridgeGameMachine.turnOn();
        bridgeGameMachine.setGame();
        bridgeGameMachine.playGame();
        while (!bridgeGameMachine.isGameSuccess() && bridgeGameMachine.wantRetry()) {
            bridgeGameMachine.retryGame();
        }
        bridgeGameMachine.printResult();
    }
}
