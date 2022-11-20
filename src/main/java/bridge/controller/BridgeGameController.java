package bridge.controller;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private BridgeGame bridgeGame;
    private MapConverter mapConverter;

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
        int bridgeSize = getBridgeSize();
        bridgeGame = new BridgeGame(getBridge(bridgeSize), new CurrentRoute(), new GameProgress());
        mapConverter = new MapConverter();
    }

    private int getBridgeSize() {
        OutputView.printBridgeSizeInputMessage();
        int bridgeSize = InputView.readBridgeSize();
        OutputView.printBlankLine();
        return bridgeSize;
    }

    private Bridge getBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
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
        return gameCommand.equals(BridgeGame.RESTART);
    }

    private void finishGame() {
        OutputView.printResultHeader();
        OutputView.printMap(mapConverter.getUpperMap(), mapConverter.getLowerMap());
        OutputView.printResult(bridgeGame.isGameSuccess(), bridgeGame.getTrialCount());
    }
}
