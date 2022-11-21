package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.BridgeNumberGenerator;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {

    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private int countGame;
    private boolean restart;

    private List<String> randomBridge;


    public BridgeController() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        inputView = new InputView();
        outputView = new OutputView();
        countGame = 1;
        restart = true;
    }
    public void startGame() {
        outputView.printGameStartMessage();
        makeBridge();


    }

    public List<String> makeBridge() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = inputView.readBridgeSize();
        randomBridge = bridgeMaker.makeBridge(size);

        return randomBridge;
    }




}
