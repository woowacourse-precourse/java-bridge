package bridge.controller;

import static bridge.util.BridgeGameConstant.RESTART_SIGN;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final OutputView outputView;
    private final InputView inputView;
    private BridgeGame bridgeGame;

    public BridgeGameController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        outputView.printStartMessage();
        setForGame();
        run();
        finishGame();
    }

    private void setForGame() {
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
    }

    private void run() {
        while (bridgeGame.isPlaying()) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame);
        }
        finishOrRestart();
    }

    private void finishOrRestart() {
        if (bridgeGame.isGameClear()) {
            return;
        }

        if (inputView.readGameCommand().equals(RESTART_SIGN)) {
            restartGame();
        }
    }

    private void restartGame() {
        bridgeGame.retry();
        run();
    }

    private void finishGame() {
        outputView.printResult(bridgeGame);
    }
}
