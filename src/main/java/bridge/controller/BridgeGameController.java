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
    }
}
