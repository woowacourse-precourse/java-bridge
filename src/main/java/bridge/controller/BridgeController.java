package bridge.controller;

import bridge.domain.Command;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeGameGenerator;
import bridge.domain.game.GameStatus;
import bridge.service.BridgeGameService;
import bridge.view.OutputView;

import static bridge.domain.game.GameStatus.PLAYING;
import static bridge.domain.game.GameStatus.SUCCESS;
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
