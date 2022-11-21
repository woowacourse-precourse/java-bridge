package bridge.domain;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.utils.Value;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
    }

    public void play() {
        outputView.printStartMessage();
        setBridgeSize();
        playing();
        quit();
    }

    private void setBridgeSize() {
        try {
            int size = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(size);
            bridgeGame.setBridge(bridge);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            setBridgeSize();
        }
    }

    private String selectMove() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return selectMove();
        }
    }

    private void moving() {
        do {
            String move = selectMove();
            bridgeGame.move(move);
            outputView.printMap(bridgeGame.getCurrentMap());
        } while (!bridgeGame.isFailed() && !bridgeGame.isSuccessful());
    }

    private void playing() {
        do {
            moving();
        } while (!bridgeGame.isSuccessful() && askRetry());
    }

    private void quit() {
        String[][] map = bridgeGame.getCurrentMap();
        boolean success = bridgeGame.isSuccessful();
        int attempts = bridgeGame.getAttempts();
        outputView.printResult(map, success, attempts);
    }

    private boolean askRetry() {
        try {
            String command = inputView.readGameCommand();
            return tryRetry(command);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return askRetry();
        }
    }

    private boolean tryRetry(String command) {
        if (command.equals(Value.RETRY)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}
