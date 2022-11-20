package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.MapConverter;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final String RESTART = "R";

    private final BridgeGame bridgeGame;
    private final MapConverter mapConverter;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame();
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

    private void initializeGame() {
        OutputView.printStartMessage();
        setBridgeSize();
        bridgeGame.setGameState();
    }

    private void setBridgeSize() {
        OutputView.printBridgeSizeInputMessage();
        int bridgeSize = InputView.readBridgeSize();
        OutputView.printBlankLine();
        bridgeGame.setBridge(bridgeSize);
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
        OutputView.printNextMovementInputMessage();
        String nextMovement = InputView.readMoving();
        bridgeGame.move(nextMovement);
        bridgeGame.updateGameProgress();
        setMap(nextMovement);
    }

    private void setRetry() {
        bridgeGame.retry();
        mapConverter.initialize();
    }

    private void setMap(String nextMovement) {
        boolean success = bridgeGame.isMovementSuccess();
        mapConverter.drawNext(nextMovement, success);
        OutputView.printMap(mapConverter.getUpperMap(), mapConverter.getLowerMap());
    }

    private boolean isRestart() {
        OutputView.printRestartMessage();
        String gameCommand = InputView.readGameCommand();
        return gameCommand.equals(RESTART);
    }

    private void finishGame() {
        OutputView.printResultHeader();
        OutputView.printMap(mapConverter.getUpperMap(), mapConverter.getLowerMap());
        OutputView.printResult(bridgeGame.isGameSuccess(), bridgeGame.getTrialCount());
    }
}
