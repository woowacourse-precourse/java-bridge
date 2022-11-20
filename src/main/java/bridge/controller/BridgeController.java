package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<String> movingData = new ArrayList<>();
    private final List<Boolean> movingResults = new ArrayList<>();

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
            String moving = inputView.readMoving();
            movingData.add(moving);
            movingResults.add(bridgeGame.move(moving, bridge.findByIndex(bridgeIndex)));
            outputView.printMap(movingData, movingResults);
        }
    }
}
