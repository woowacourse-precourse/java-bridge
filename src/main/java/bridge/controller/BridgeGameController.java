package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final OutputView outputView;
    private final InputView inputView;
    private BridgeGame bridgeGame;

    public BridgeGameController(
            OutputView outputView,
            InputView inputView
    ) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        outputView.printStartMessage();
        setForGame();
        run();
    }

    private void setForGame() {
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    private void run() {
        do {
            String direction = inputView.readMoving();
            bridgeGame.move(direction);
            outputView.printMap(bridgeGame.getResultToString());
        }
        while (bridgeGame.isPlaying());
    }
}
