package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.BridgeMaker;
import bridge.model.constant.Message;
import bridge.model.constant.Status;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private Bridge bridge;
    private int tryCount = 1;

    public void start() {
        outputView.printStartGame();
        outputView.printInputBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public boolean move() {
        if (isFinished(bridge)) {
            return false;
        }
        outputView.printInputMove();
        String move = inputView.readMoving();
        boolean result = bridge.isMovable(move);
        outputView.printMap(move, result);
        return result;
    }

    public boolean retry() {
        if (isFinished(bridge)) {
            return false;
        }
        outputView.printRestartGame();
        if (inputView.readGameCommand().equals(Message.QUIT.getMessage())) {
            return false;
        }
        prepareToRetry();
        outputView.clearMap();
        return true;
    }

    public void end() {
        outputView.printResult(bridge.getStatus().getMessage(), tryCount);
    }

    public boolean isFinished(Bridge bridge) {
        return bridge.getStatus() == Status.GAME_FINISHED;
    }

    public void prepareToRetry() {
        tryCount++;
        bridge.clearUser();
    }
}
