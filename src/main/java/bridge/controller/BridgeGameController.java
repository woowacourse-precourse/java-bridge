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
        initializeGame();
        playGame();
        finishGame();
    }

    private void initializeGame() {
        OutputView.printStartMessage();
        OutputView.printBlankLine();
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
        if (isGameSuccess()) {
            return;
        }
        retryGame();
    }

    private void retryGame() {
        while (isRestart()) {
            bridgeGame.retry();
            mapConverter.initialize();
            takeTrial();
            if (isGameSuccess()) {
                return;
            }
        }
    }

    private void takeTrial() {
        do {
            if (isGameSuccess()) {
                return;
            }
            takeTurn();
        } while (bridgeGame.isMovementSuccess());
    }

    private void takeTurn() {
        OutputView.printNextMovementInputMessage();
        String nextMovement = InputView.readMoving();
        bridgeGame.move(nextMovement);
        bridgeGame.setResult();
        setMap(nextMovement);
    }

    private boolean isGameSuccess() {
        return bridgeGame.isGameSuccess();
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
