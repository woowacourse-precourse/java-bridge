package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.utils.message.FixedMessage;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<String> bridge = new ArrayList<>();
    private final List<String> movingData = new ArrayList<>();
    private final List<Boolean> movingResults = new ArrayList<>();

    public void startGame() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        System.out.println(FixedMessage.GAME_START.getMessage() + "\n");
        bridge.addAll(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    public void playGame() {
        BridgeGame bridgeGame = new BridgeGame();

        for (String block : bridge) {
            String moving = inputView.readMoving();
            movingData.add(moving);
            movingResults.add(bridgeGame.move(moving, block));
            outputView.printMap(movingData, movingResults);
        }
    }
}
