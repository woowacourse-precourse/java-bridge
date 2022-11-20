package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.*;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final int INIT_POSITION = 0;
    private static final int INIT_TRIAL = 1;
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

        Bridge bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        User user = new User(INIT_POSITION, INIT_TRIAL);
        BridgeGame bridgeGame = new BridgeGame(bridge, user);

        start(bridgeGame);
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
        if (getRetryIntention().equals(RETRY)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }

    private String getRetryIntention() {
        return inputView.readGameCommand();
    }
}
