package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private static final String RETRY = "R";
    private static final String QUIT = "Q";

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
        boolean mobility = true;
        int moveCount = 0;

        while (mobility && bridgeGame.hasBridgeToMove(moveCount)) {
            outputView.printMovingMsg();
            mobility = bridgeGame.move(moveCount, inputView.readMoving());
            outputView.printMap(bridgeGame.getBridgeGameResult());
            moveCount++;
        }
        finish(moveCount);
    }

    private void finish(int moveCount) {
        if (bridgeGame.isSuccess(moveCount)) {
            bridgeGame.success();
            play = false;
            return;
        }
        outputView.printGameCommandMsg();
        checkPlay(inputView.readGameCommand());
    }

    private void checkPlay(String command) {
        if (command.equals(RETRY)) {
            bridgeGame.retry();
        }

        if (command.equals(QUIT)) {
            play = false;
        }
    }
}
