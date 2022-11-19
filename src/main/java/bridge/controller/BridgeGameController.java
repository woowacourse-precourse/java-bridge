package bridge.controller;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeGameResult;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private final BridgeGameResult bridgeGameResult;

    private boolean play;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeGameResult = new BridgeGameResult();
        bridgeGame = new BridgeGame(bridgeGameResult);
        play = true;
    }

    public void play() {
        start();
        Bridge bridge = makeBridge(makeBridgeSize());
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

    private Bridge makeBridge(int size) {
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    private int makeBridgeSize() {
        outputView.printBridgeSizeMsg();
        return inputView.readBridgeSize();
    }

    private void moveBridge(Bridge bridge) {
        int moveCount;
        for (moveCount = 0; moveCount < bridge.getSize(); moveCount++) {
            outputView.printMovingMsg();

            String moving = inputView.readMoving();
            Boolean mobility = bridgeGame.move(bridge, moveCount, moving);
            outputView.printMap(bridgeGameResult.getMoveResult());

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
