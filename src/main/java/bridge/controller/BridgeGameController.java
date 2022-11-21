package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.*;
import bridge.service.BridgeGame;
import bridge.util.Log;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final String RETRY = "R";

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void run() {
        inputView.showStartMessage();

        Bridge bridge = createBridge();
        User user = new User();
        BridgeGame bridgeGame = new BridgeGame(bridge, user);

        start(bridgeGame);
    }

    private Bridge createBridge() {
        try {
            return new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return createBridge();
        }
    }

    public void start(BridgeGame bridgeGame) {
        do {
            boolean moveFlag = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getBridgeState());
            if (!moveFlag && !checkRetry(bridgeGame)) {
                break;
            }
        } while (bridgeGame.canContinue());
        outputView.printResult(bridgeGame);
    }

    private boolean checkRetry(BridgeGame bridgeGame) {
        if (hasUserRetryIntention()) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private boolean hasUserRetryIntention() {
        return getRetryIntention().equals(RETRY);
    }

    private String getRetryIntention() {
        return inputView.readGameCommand();
    }
}
