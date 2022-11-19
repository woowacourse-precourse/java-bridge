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
    private final BridgeGame bridgeGame;

    private boolean play;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGame = new BridgeGame();
        play = true;
    }

    public void play() {
        start();
        Bridge bridge = makeBridge();
        while (play) {
            moveBridge(bridge);
        }
        end();
    }

    private void start() {
        outputView.printGameStartMsg();
    }

    private void end() {
        outputView.printResult(bridgeGameResult);
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

    private void moveBridge(Bridge bridge) {
        int moveCount;
        for (moveCount = 0; moveCount < bridge.getSize(); moveCount++) {
            outputView.printMovingMsg();

            String moving = inputView.readMoving();
            Boolean mobility = bridgeGame.move(bridge, moveCount, moving);
            outputView.printMap(bridgeGameResult);

            if (isFail(mobility)) {
                break;
            }
        }

        if (moveCount == bridge.getSize()) {
            bridgeGameResult.setSuccess();
            play = false;
        }
    }

    private boolean isFail(Boolean mobility) {
        if (mobility.equals(false)) {
            outputView.printGameCommandMsg();
            checkPlay(inputView.readGameCommand());
            return true;
        }

        return false;
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
