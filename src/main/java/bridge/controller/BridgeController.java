package bridge.controller;

import bridge.domain.Command;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameGenerator;
import bridge.domain.GameStatus;
import bridge.service.BridgeGameService;
import bridge.view.OutputView;

import static bridge.domain.GameStatus.PLAYING;
import static bridge.domain.GameStatus.SUCCESS;
import static bridge.support.ErrorMessage.UNEXPECTED_EXCEPTION;

public class BridgeController {

    private final OutputView outputView;
    private final ReadController readController;
    private BridgeGameService service;

    public BridgeController(ReadController readController) {
        this.outputView = new OutputView();
        this.readController = readController;
    }

    public void run() {
        outputView.printStartMessage();
        service = new BridgeGameService(initBridgeGame());

        try {
            GameStatus status = playBridgeGame();
            outputView.printResult(service.getResultDto(status));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        } catch (OutOfMemoryError | StackOverflowError e) {
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
        } while (PLAYING.equals(status) || isRetry(status));
        return status;
    }

    private GameStatus crossBridge() {
        GameStatus status = PLAYING;
        while (PLAYING.equals(status)) {
            String moving = readController.readMoving();
            status = service.crossBridgeUnit(moving);

            outputView.printMap(service.getMapDto());
        }
        return status;
    }

    private boolean isRetry(GameStatus status) {
        if (SUCCESS.equals(status)) {
            return false;
        }
        Command command = readController.readGameCommand();
        return service.executeIfRetry(command);
    }
}
