package bridge.controller;

import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeGameGenerator;
import bridge.domain.game.GameStatus;
import bridge.service.BridgeGameService;
import bridge.view.OutputView;

import static bridge.domain.game.GameStatus.FAILED;
import static bridge.support.ErrorMessage.UNEXPECTED_EXCEPTION;

public class BridgeController {

    private final OutputView outputView;
    private final ReadController readController;
    private BridgeGameService service;

    public BridgeController() {
        this.outputView = new OutputView();
        this.readController = new ReadController();
    }

    public void run() {
        outputView.printStartMessage();
        service = new BridgeGameService(initBridgeGame());

        try {
            GameStatus status = playBridgeGame();
            outputView.printResult(service.getResultDto(status));
        } catch (Exception | Error e) {
            OutputView.printError(UNEXPECTED_EXCEPTION);
        }
    }

    private BridgeGame initBridgeGame() {
        int bridgeSize = readController.readBridgeSize();
        return BridgeGameGenerator.generate(bridgeSize);
    }

    private GameStatus playBridgeGame() {
        GameStatus status;
        do {
            status = crossBridge();
        } while (isPlaying(status));
        return status;
    }

    private GameStatus crossBridge() {
        GameStatus status = FAILED;
        while (service.isPlaying()) {
            status = crossBridgeUnit();
            outputView.printMap(service.getMapDto());
        }
        return status;
    }

    private GameStatus crossBridgeUnit() {
        String moving = readController.readMoving();
        return service.crossBridgeUnit(moving);
    }

    private boolean isPlaying(GameStatus status) {
        if (service.isPlaying()) {
            return true;
        }
        return isRetryIfFailed(status);
    }

    private boolean isRetryIfFailed(GameStatus status) {
        if (!FAILED.equals(status)) {
            return false;
        }
        String command = readController.readGameCommand();
        return service.executeGameCommand(command);
    }
}
