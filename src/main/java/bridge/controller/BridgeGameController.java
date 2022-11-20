package bridge.controller;

import static bridge.util.BridgeGameConstant.RESTART_SIGN;

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
        restartGame();
    }

    private void setForGame() {
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }

    private void run() {
        do {
            String direction = inputView.readMoving();
            bridgeGame.move(direction);
            outputView.printMap(bridgeGame.getPathResultToString());
        }
        while (bridgeGame.isPlaying());
    }

    private void restartGame() {
        while (inputView.readGameCommand().equals(RESTART_SIGN)) {
            bridgeGame.retry();
            run();
        }
    }
}
