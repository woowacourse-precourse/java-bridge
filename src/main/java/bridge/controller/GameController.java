package bridge.controller;

import bridge.Progress;
import bridge.constant.BridgePattern;
import bridge.constant.GameCondition;
import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        try {
            outputView.startMsg();
            List<String> bridge = generateBridge();
            BridgeGame bridgeGame = new BridgeGame(bridge, new Progress(bridge.size()));
            GameCondition gameCondition = startGame(bridgeGame);
        } catch (IllegalArgumentException exception) {
            outputView.printException(exception.getMessage());
        }
    }

    public List<String> generateBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private GameCondition startGame(BridgeGame bridgeGame) {
        while (true) {
            GameCondition gameCondition = bridgeGame.move(selectMove());
            outputView.printMap(bridgeGame.exportProgress());
        }
    }

}


