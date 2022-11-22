package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.drawer.BridgeDrawer;
import bridge.constant.ResultState;
import bridge.model.BridgeGame;
import view.input.InputView;
import bridge.drawer.BridgeCase;
import view.output.OutputView;

public class BridgeGameController {

    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static final BridgeDrawer bridgeDrawer = new BridgeDrawer();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final int INIT_COUNT = 0;
    private static BridgeGame bridgeGame;
    private static int bridgeSize;

    public void start() {
        outputView.printStartMessage();
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(getBridgeSize()), INIT_COUNT);
        run();
    }

    public void run() {
        bridgeInit();
        if (!isAvailableBridge()) {
            handlingWrongAnswer();
            return;
        }
        sendResult(ResultState.SUCCESS);
    }

    public void bridgeInit() {
        bridgeDrawer.bridgeInit();
    }

    public boolean isAvailableBridge() {
        for (int index = INIT_COUNT; index < bridgeSize; index++) {
            String bridgeToMove = getBridgeToMove();
            sendBridgeShape(bridgeGame.move(bridgeToMove, index), bridgeGame.isAnswer(bridgeToMove, index));
            if (!bridgeGame.isAnswer(bridgeToMove, index)) return false;
        }
        return true;
    }

    public void handlingWrongAnswer() {
        if (bridgeGame.retry(getRetryCode())) {
            run();
            return;
        }
        sendResult(ResultState.FAIL);
    }

    public int getBridgeSize() {
        bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }

    public String getBridgeToMove() {
        return inputView.readMoving();
    }

    public String getRetryCode() {
        return inputView.readGameCommand();
    }

    public void sendBridgeShape(BridgeCase bridgeCase, boolean isAnswer) {
        bridgeDrawer.drawBridge(bridgeCase, isAnswer);
        outputView.printMap(bridgeDrawer.combineBridge());
    }

    public void sendResult(ResultState resultState) {
        outputView.printEndMessage();
        outputView.printMap(bridgeDrawer.combineBridge());
        outputView.printResult(bridgeGame.getCount(), resultState.getState());
    }
}