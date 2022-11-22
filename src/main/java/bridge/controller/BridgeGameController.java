package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeShape;
import bridge.domain.MyBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;


public class BridgeGameController {

    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private OutputView outputView = new OutputView();

    public void start() {
        outputView.printStart();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> answerBridge = bridgeMaker.inputBridgeSize();
        MyBridge myBridge = new MyBridge(answerBridge);
        bridgeGame.move(myBridge);
    }

}
