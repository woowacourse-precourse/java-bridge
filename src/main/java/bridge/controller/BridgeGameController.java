package bridge.controller;

import bridge.domain.BridgeGameService;
import bridge.Constants.CommandConstant;
import bridge.service.BridgeGame;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Objects;


public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGameService bridgeGameService;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }


    public void run() {
        startGame();
        executeGame();
        getResult();
    }

    private void startGame() {
        int size = inputView.readBridgeSize();
        this.bridgeGameService = new BridgeGame(size);
    }

    private void executeGame() {
        String movement = inputView.readMoving();
        this.bridgeGameService.move(movement);
        List<List<String>> currentMaps = this.bridgeGameService.getMaps();
        outputView.printMap(currentMaps);
        controlGameFlow(movement);
    }

    private void controlGameFlow(String movement) {
        if (!bridgeGameService.isValidLastStep(movement)) {
            retry();
        }
        if (bridgeGameService.isValidLastStep(movement) && !bridgeGameService.getSuccessStatus()) {
            executeGame();
        }
    }


    private void getResult() {
        List<List<String>> currentMaps = bridgeGameService.getMaps();
        boolean gameStatus = bridgeGameService.getSuccessStatus();
        int attemptCount = bridgeGameService.getAttemptCount();
        outputView.printFinalMap(currentMaps);
        outputView.printResult(attemptCount, gameStatus);
    }


    private void retry() {
        String gameCommand = inputView.readGameCommand();
        if (Objects.equals(gameCommand, CommandConstant.REDO)) {
            bridgeGameService.retry();
            executeGame();
        }
    }
}
