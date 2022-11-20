package bridge;

import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeGameGenerator;
import bridge.domain.game.GameStatus;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.domain.game.GameStatus.FAILED;
import static bridge.domain.game.GameStatus.PLAYING;
import static bridge.support.ErrorMessage.UNEXPECTED_EXCEPTION;

public class BridgeApplication {

    private final OutputView outputView;
    private final InputView inputView;
    private BridgeGameService service;
    private GameStatus status;

    public BridgeApplication() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.service = new BridgeGameService();
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
        while (PLAYING.equals(status)) {
            crossBridge(bridgeGame);
            status = readGameCommandIfFailed(bridgeGame);
        }
    }

    private void crossBridge(BridgeGame bridgeGame) {
        while (PLAYING.equals(status)) {
            crossBridgeUnit(bridgeGame);
            outputView.printMap(bridgeGame);
        }
    }

    private void crossBridgeUnit(BridgeGame bridgeGame) {
        try {
            String moving = inputView.readMoving();
            status = service.crossBridgeUnit(bridgeGame, moving);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private GameStatus readGameCommandIfFailed(BridgeGame bridgeGame) {
        try {
            if (FAILED.equals(status)) {
                String command = inputView.readGameCommand();
                return service.readGameCommand(bridgeGame, status, command);
            }
            return status;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return readGameCommandIfFailed(bridgeGame);
        }
    }
}
