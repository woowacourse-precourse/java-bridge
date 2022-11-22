package bridge.controller;

import bridge.domain.BridgeGameService;
import bridge.service.BridgeGame;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Objects;


public class BridgeGameController {

    InputView inputView;
    OutputView outputView;
    BridgeGameService bridgeGameService;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        startGame();
        makeMove();
    }

    private void startGame() {
        int size = inputView.readBridgeSize();
        this.bridgeGameService = new BridgeGame(size);
    }

    private void makeMove() {
        String movement = inputView.readMoving();
        this.bridgeGameService.move(movement);
        List<List<String>> currentMaps = this.bridgeGameService.getMaps();
        outputView.printMap(currentMaps);

        if (!bridgeGameService.isValidLastStep(movement)) {
            retry();
        }
        if (bridgeGameService.isValidLastStep(movement) && !bridgeGameService.getSuccessStatus()) {
            makeMove();
        }
        if (bridgeGameService.isValidLastStep(movement) && bridgeGameService.getSuccessStatus()) {
            getResult();
        }
    }

    private void getResult() {
        List<List<String>> currentMaps = this.bridgeGameService.getMaps();
        boolean gameStatus = this.bridgeGameService.getSuccessStatus();
        int attemptCount = this.bridgeGameService.getAttemptCount();
        outputView.printFinalMap(currentMaps);
        outputView.printResult(attemptCount, gameStatus);
    }

    private void retry() {
        String gameCommand = inputView.readGameCommand();
        if (Objects.equals(gameCommand, "R")) {
            bridgeGameService.retry();
            makeMove();
        }
        if (Objects.equals(gameCommand, "Q")) {
            getResult();
        }
    }
}
