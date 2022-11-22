package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private boolean playGame = true;

    private BridgeGame bridgeGame = new BridgeGame();

    public void setUp() {
        OutputView.reset();
        System.out.printf(OutputView.START_MESSAGE);
        bridgeInput();
    }

    public void start() {
        setUp();
        while (playGame != false) {
            moveInput();
            if (bridgeGame.successGame()) {
                break;
            }
            retryInput();
        }
        System.out.println(OutputView.printResult(bridgeGame.successGame(), bridgeGame.retryCount));
    }

    public void moveInput() {
        boolean game = false;
        while (game != true) {
            String inputMove = InputView.readMoving();
            printProcessBridge(inputMove);
            game = bridgeGame.move(inputMove);
        }

    }

    public void bridgeInput() {
        boolean game = false;
        while (game != true) {
            String inputBridgeSize = InputView.readBridgeSize();
            game = bridgeGame.bridge(inputBridgeSize);
        }

    }

    public void retryInput() {
        boolean game = false;
        while (game != true) {
            String inputRetry = InputView.readGameCommand();
            playGame = bridgeGame.retry(inputRetry);
            break;
        }
    }

    private void printProcessBridge(String inputMove) {
        System.out.println(OutputView.printMap(bridgeGame.bridge, inputMove, bridgeGame.count));
    }
}
