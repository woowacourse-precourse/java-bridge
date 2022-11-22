package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void startNewGame(BridgeMaker bridgeMaker) {
        outputView.printStart();
        bridgeGame = new BridgeGame(createNewBridge(bridgeMaker));
    }

    public void play() {
        while (bridgeGame.isGamePlaying()) {
            move();
            printMoveResult();
            checkGameEnd();
        }
        printFinalResult();
    }

    private void move() {
        while (true) {
            try {
                bridgeGame.move(inputView.readMoving());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private Bridge createNewBridge(BridgeMaker bridgeMaker) {
        while (true) {
            try {
                return new Bridge(generateBridge(bridgeMaker));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private List<String> generateBridge(BridgeMaker bridgeMaker) {
        return bridgeMaker.makeBridge(requestBridgeLength());
    }

    private int requestBridgeLength() {
        return inputView.readBridgeSize();
    }

    private void printMoveResult() {
        outputView.printMap(bridgeGame.getCurrentMap());
    }

    private void checkGameEnd() {
        if (bridgeGame.isGameOver()) {
            requestGameRestart();
        }
    }

    private void requestGameRestart() {
        while (true) {
            try {
                bridgeGame.retry(inputView.readGameCommand());
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void printFinalResult() {
        outputView.printResult(bridgeGame.getCurrentMap(), bridgeGame.getTryCount(), bridgeGame.isGamePass());
    }

}
