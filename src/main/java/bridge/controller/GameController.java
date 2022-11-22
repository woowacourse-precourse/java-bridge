package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame;
    boolean hasRetried;

    private void setUpGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        try {
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            bridgeGame = new BridgeGame(bridge);
        } catch (IllegalArgumentException e) {
            outputView.printErrorNotice(e);
            setUpGame();
        }
    }

    private void start() {
        outputView.printStartNotice();
        outputView.printBridgeSizeInputNotice();
        setUpGame();
    }

    private void play() {
        boolean hasMoved;
        do {
            outputView.printMovingDirectionInputNotice();
            hasMoved = moveByInput();
            outputView.printMap(bridgeGame.getResult());
            if (bridgeGame.checkWin()) {
                break;
            }
        } while (hasMoved);
    }

    private boolean moveByInput() {
        try {
            String moving = inputView.readMoving();
            return bridgeGame.move(moving);
        } catch (IllegalArgumentException e) {
            outputView.printErrorNotice(e);
            return moveByInput();
        }
    }

    private void reTry() {
        outputView.printRestartOrQuitInputNotice();
        hasRetried = retryByInput();
    }

    private boolean retryByInput() {
        try {
            String gameCommand = inputView.readGameCommand();
            return bridgeGame.retry(gameCommand);
        } catch (IllegalArgumentException e) {
            outputView.printErrorNotice(e);
            return retryByInput();
        }
    }

    private void end() {
        outputView.printResult(bridgeGame.getResult(), bridgeGame.checkWin(), bridgeGame.getCountOfTry());
    }

    public void run() {
        start();
        do {
            play();
            if (bridgeGame.checkWin()) {
                break;
            }
            reTry();
        } while (hasRetried);
        end();
    }

}
