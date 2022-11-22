package bridge.presentation;

import bridge.BridgeMaker;
import bridge.application.BridgeGame;
import bridge.domain.Bridge;
import bridge.domain.Moving;
import bridge.presentation.view.InputView;
import bridge.presentation.view.OutputView;

public class BridgeGameSystem {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameSystem(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = initBridgeGame();
    }

    private Moving move() {
        Moving moving = bridgeGame.move(inputView.readMoving());
        outputView.printMap(moving);
        return moving;
    }

    private BridgeGame initBridgeGame() {
        outputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        return new BridgeGame(bridge);
    }

}
