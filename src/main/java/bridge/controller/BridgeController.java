package bridge.controller;

import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeGameGenerator;
import bridge.domain.game.GameStatus;
import bridge.service.BridgeGameService;
import bridge.view.OutputView;

import static bridge.domain.game.GameStatus.FAILED;
import static bridge.domain.game.GameStatus.PLAYING;
import static bridge.support.ErrorMessage.UNEXPECTED_EXCEPTION;

public class BridgeController {

    private final OutputView outputView;
    private final ReadController readController;
    private BridgeGameService service;
    private GameStatus status;

    public BridgeController() {
        this.outputView = new OutputView();
        this.readController = new ReadController();
        this.status = PLAYING;
    }

    public void run() {
        outputView.printStartMessage();
        service = new BridgeGameService(initBridgeGame());

        try {
            playBridgeGame();
            outputView.printResult(service.getResultDto(status));
        } catch (Exception | Error e) {
            OutputView.printError(UNEXPECTED_EXCEPTION);
        }
    }

    private BridgeGame initBridgeGame() {
        int bridgeSize = readController.readBridgeSize();
        return BridgeGameGenerator.generate(bridgeSize);
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
        String moving = readController.readMoving();
        status = service.crossBridgeUnit(moving);
    }

    private GameStatus executeGameCommand() {
        String command = readController.readGameCommand();
        return service.executeGameCommand(command);
    }
}
