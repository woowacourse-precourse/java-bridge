package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeGame;
import bridge.domain.MyBridge;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class BridgeGameController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    public void start() {
        OutputView.printStart();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> answerBridge = bridgeMaker.inputBridgeSize();
        MyBridge myBridge = new MyBridge(answerBridge, new ArrayList<>());
        bridgeGame.move(myBridge);
    }

}
