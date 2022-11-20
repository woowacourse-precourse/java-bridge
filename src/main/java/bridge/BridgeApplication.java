package bridge;

import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeGameGenerator;
import bridge.domain.bridge.BridgeUnit;
import bridge.domain.Command;
import bridge.domain.game.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.domain.Command.RETRY;
import static bridge.domain.game.GameStatus.FAILED;
import static bridge.domain.game.GameStatus.PLAYING;
import static bridge.support.ErrorMessage.UNEXPECTED_EXCEPTION;

public class BridgeApplication {

    private final OutputView outputView;
    private final InputView inputView;
    private GameStatus status;

    public BridgeApplication() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.status = PLAYING;
    }

    public void run() {
        outputView.printStartMessage();
        BridgeGame bridgeGame = initBridgeGame();

        try {
            playBridgeGame(bridgeGame);
            outputView.printResult(bridgeGame, status);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        } catch (Exception | Error e) {
            outputView.printError(UNEXPECTED_EXCEPTION);
        }
    }

    private BridgeGame initBridgeGame() {
        try {
            int bridgeSize = readBridgeSize();
            return BridgeGameGenerator.generate(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return initBridgeGame();
        }
    }

    private int readBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readBridgeSize();
        }
    }

    private void playBridgeGame(BridgeGame bridgeGame) {
        do {
            crossBridge(bridgeGame);
            readGameCommandIfFailed(bridgeGame);
        } while (PLAYING.equals(status));
    }

    private void crossBridge(BridgeGame bridgeGame) {
        while (PLAYING.equals(status)) {
            BridgeUnit nextUnit = readNextBridgeUnit();

            status = bridgeGame.move(nextUnit);
            outputView.printMap(bridgeGame);
        }
    }

    private BridgeUnit readNextBridgeUnit() {
        try {
            String moving = inputView.readMoving();
            return BridgeUnit.from(moving);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readNextBridgeUnit();
        }
    }

    private void readGameCommandIfFailed(BridgeGame bridgeGame) {
        if (FAILED.equals(status)) {
            Command command = readCommand();
            invokeIfRetry(bridgeGame, command);
        }
    }

    private Command readCommand() {
        try {
            String code = inputView.readGameCommand();
            return Command.from(code);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readCommand();
        }
    }

    private void invokeIfRetry(BridgeGame bridgeGame, Command command) {
        if (RETRY.equals(command)) {
            status = bridgeGame.retry();
        }
    }
}
