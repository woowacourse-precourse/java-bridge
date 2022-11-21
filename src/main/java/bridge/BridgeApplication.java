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
        this.status = PLAYING;
    }

    public void run() {
        outputView.printStartMessage();
        service = new BridgeGameService(initBridgeGame());

        try {
            playBridgeGame();
            outputView.printResult(service.getResultDto(status));
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

    private void playBridgeGame() {
        while (PLAYING.equals(status)) {
            crossBridge();
            if (FAILED.equals(status)) {
                status = executeGameCommand();
            }
        }
    }

    private void crossBridge() {
        while (PLAYING.equals(status)) {
            crossBridgeUnit();
            outputView.printMap(service.getMapDto());
        }
    }

    private void crossBridgeUnit() {
        try {
            String moving = inputView.readMoving();
            status = service.crossBridgeUnit(moving);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }

    private GameStatus executeGameCommand() {
        try {
            String command = inputView.readGameCommand();
            return service.executeGameCommand(command);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return executeGameCommand();
        }
    }
}
