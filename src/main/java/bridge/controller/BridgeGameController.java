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
        mapConverter.drawNext(movement, movementSuccess);
        OutputView.printMap(mapConverter.getDrawnMap());
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
        mapConverter.reset();
    }

    private boolean isRestart() {
        OutputView.printRestartMessage();
        String gameCommand = InputView.readGameCommand();
        return gameCommand.equals(BridgeGame.RESTART);
    }

    private void finishGame() {
        OutputView.printResultHeader();
        OutputView.printMap(mapConverter.getDrawnMap());
        OutputView.printResult(bridgeGame.isGameSuccess(), bridgeGame.getTrialCount());
    }
}
