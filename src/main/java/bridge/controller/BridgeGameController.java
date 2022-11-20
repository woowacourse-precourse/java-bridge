package bridge.controller;

import bridge.BridgeGame;
import bridge.model.BridgeSize;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private BridgeSize bridgeSize;
    private Player player;
    private String retryString;
    private String moveString;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        player = new Player();
        bridgeGame = new BridgeGame();
    }

    private BridgeSize makeBridge() {
        outputView.printStart();
        bridgeSize = null;
        do {
            outputView.printReadBridgeSize();
            validBridgeSize();
        } while (bridgeSize == null);
        return bridgeSize;
    }

    private void validBridgeSize() {
        try {
            bridgeSize = new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            outputView.printError("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void playGame() {
        bridgeGame = new BridgeGame(makeBridge(), player);
    }
}
