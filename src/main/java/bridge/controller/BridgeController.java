package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private Bridge bridge;

    public void startGame() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        outputView.printGameStart();
        bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    public void playGame() {
        BridgeGame bridgeGame = new BridgeGame();

        for (int bridgeIndex = 0; bridgeIndex < bridge.length(); bridgeIndex++) {
            bridgeGame.move(inputView.readMoving(), bridge.findBlockByIndex(bridgeIndex));
            outputView.printMap(bridgeGame);
        }
    }
}
