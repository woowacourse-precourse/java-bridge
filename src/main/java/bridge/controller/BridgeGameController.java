package bridge.controller;

import bridge.domain.CurrentRoute;
import bridge.domain.GameProgress;
import bridge.service.BridgeGame;
import bridge.service.MapConverter;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private BridgeGame bridgeGame;
    private final MapConverter mapConverter;

    public BridgeGameController() {
        this.mapConverter = new MapConverter();
    }

    public void process() {
        initializeGame();
        playGame();
        finishGame();
    }

    public void initializeGame() {
        OutputView.printStartMessage();
        bridgeGame = new BridgeGame(
                BridgeInitializer.initialize(),
                new CurrentRoute(),
                new GameProgress()
        );
        OutputView.printBlankLine();
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
        String movement = getMovement();
        move(movement);
        boolean movementSuccess = bridgeGame.isMovementSuccess();
        mapConverter.drawNext(movement, movementSuccess);
        OutputView.printMap(mapConverter.getDrawnMap());
    }

    private String getMovement() {
        try {
            OutputView.printNextMovementInputMessage();
            return InputView.readMoving();
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return getMovement();
        }
    }

    private void move(String movement) {
        bridgeGame.move(movement);
        bridgeGame.updateGameProgress();
    }

    private void setRetry() {
        bridgeGame.retry();
        mapConverter.reset();
    }

    private boolean isRestart() {
        try {
            OutputView.printRestartMessage();
            String gameCommand = InputView.readGameCommand();
            return gameCommand.equals(BridgeGame.RESTART);
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            return isRestart();
        }
    }

    private void finishGame() {
        OutputView.printResultHeader();
        OutputView.printMap(mapConverter.getDrawnMap());
        OutputView.printResult(bridgeGame.isGameSuccess(), bridgeGame.getTrialCount());
    }
}
