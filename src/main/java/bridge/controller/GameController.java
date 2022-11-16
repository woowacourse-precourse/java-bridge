package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public GameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void start() {
        outputView.startGame();
        int bridgeSize = inputView.readBridgeSize();
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        bridgeGame.createBridge(bridgeSize);
    }
}
