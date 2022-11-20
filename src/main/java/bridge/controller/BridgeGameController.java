package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.CurrentRoute;
import bridge.domain.GameProgress;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private BridgeGame bridgeGame;
    private final MapConverterController mapConverterController;

    public BridgeGameController() {
        this.mapConverterController = new MapConverterController();
    }

    public void process() {
        try {
            initializeGame();
            playGame();
            finishGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void initializeGame() {
        OutputView.printStartMessage();
        bridgeGame = new BridgeGame(
                BridgeInitializer.initialize(),
                new CurrentRoute(),
                new GameProgress()
        );
    }

    private void playGame() {
        takeTrial();
        if (bridgeGame.isGameSuccess()) {
            return;
        }
        retryGame();
    }

    private void retryGame() {
        while (isRestart()) {
            setRetry();
            takeTrial();
            if (bridgeGame.isGameSuccess()) {
                return;
            }
        }
    }

    private void takeTrial() {
        do {
            if (bridgeGame.isGameSuccess()) {
                return;
            }
            takeTurn();
        } while (bridgeGame.isMovementSuccess());
    }

    private void takeTurn() {
        String movement = getMove();
        boolean movementSuccess = bridgeGame.isMovementSuccess();
        mapConverterController.drawMap(movement, movementSuccess);
    }

    private String getMove() {
        OutputView.printNextMovementInputMessage();
        String nextMovement = InputView.readMoving();
        bridgeGame.move(nextMovement);
        bridgeGame.updateGameProgress();
        return nextMovement;
    }

    private void setRetry() {
        bridgeGame.retry();
        mapConverterController.initialize();
    }

    private boolean isRestart() {
        OutputView.printRestartMessage();
        String gameCommand = InputView.readGameCommand();
        return gameCommand.equals(BridgeGame.RESTART);
    }

    private void finishGame() {
        OutputView.printResultHeader();
        mapConverterController.drawLatestMap();
        OutputView.printResult(bridgeGame.isGameSuccess(), bridgeGame.getTrialCount());
    }
}
