package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();

        BridgeRandomNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        bridgeGame = new BridgeGame(numberGenerator);
    }

    public void run() {
        int bridgeSize = inputView.readBridgeSize();
        boolean completeness = false;

        bridgeGame.initGame(bridgeSize);

        outputView.printMap(bridgeGame.getBridge(), move());
    }

    private List<String> move() {
        String moving = inputView.readMoving();

        return bridgeGame.move(moving);
    }
}
