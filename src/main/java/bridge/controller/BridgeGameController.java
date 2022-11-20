package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    private boolean play;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void play() {
        start();
        while (play) {
            moveBridge();
        }
        end();
    }

    private void start() {
        outputView.printGameStartMsg();
        setUp();
    }

    private void setUp() {
        play = true;
        bridgeGame = new BridgeGame(makeBridge());
    }

    private void end() {
        outputView.printResult(bridgeGame.getBridgeGameResult());
    }

    private Bridge makeBridge() {
        outputView.printBridgeSizeMsg();
        while (true) {
            try {
                int size = inputView.readBridgeSize();
                return bridgeMaker.makeBridge(makeShape(size));
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private List<String> makeShape(int size) {
        return bridgeMaker.makeBridge(size);
    }

    private void moveBridge() {
        boolean canMove = true;
        int moveCount = 0;
        while (canMove && bridgeGame.hasBridgeToMove(moveCount)) {
            outputView.printMovingMsg();
            canMove = bridgeGame.move(moveCount, inputView.readMoving());
            outputView.printMap(bridgeGame.getBridgeGameResult());
            moveCount++;
        }
        finish(canMove);
    }

    private void finish(boolean canMove) {
        if (canMove) {
            succeed();
        }
        fail();
    }

    private void succeed() {
        bridgeGame.succeed();
        play = false;
    }

    private void fail() {
        outputView.printGameCommandMsg();
        if (bridgeGame.doesRetry(inputView.readGameCommand())) {
            bridgeGame.retry();
            return;
        }
        play = false;
    }
}
