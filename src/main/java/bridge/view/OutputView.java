package bridge.view;

import bridge.controller.BridgeGame;

public class OutputView {

    private BridgeGame bridgeGame = new BridgeGame();

    public void printMap() {
        System.out.println(bridgeGame.getMergeBridge());
    }

    public void printResult() {
        System.out.println(bridgeGame.endGame());
    }
}
