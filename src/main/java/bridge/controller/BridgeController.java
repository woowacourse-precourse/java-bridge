package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMatcher;
import bridge.domain.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {

    public void startGame() {
        List<String> bridge = generateBridge();
        BridgeMatcher bridgeMatcher = makeBridgeMatcher();
        OutputView outputView = makeResultBridge();
        BridgeGame bridgeGame = startBridgeGame(bridge, bridgeMatcher);
    }

    private BridgeGame startBridgeGame(List<String> bridge, BridgeMatcher bridgeMatcher) {
        return new BridgeGame(bridge, bridgeMatcher);
    }

    private OutputView makeResultBridge() {
        String upBridge = "";
        String downBridge = "";
        GameResult gameResult = new GameResult(upBridge, downBridge);
        return new OutputView(gameResult);
    }

    private BridgeMatcher makeBridgeMatcher() {
        List<Boolean> matchedBridge = new ArrayList<>();
        int firstTry = 1;
        return new BridgeMatcher(matchedBridge, firstTry);
    }

    private List<String> generateBridge() {
        OutputView.printGameStart();
        int size = InputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        return bridgeMaker.makeBridge(size);
    }
}