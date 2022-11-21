package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private InputView inputView = new InputView();
    private int size = 0;
    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private List<String> bridgeState = new ArrayList<>();


    public Controller() {
        setBridge();
    }

    public void setBridge() {
        size = inputView.readBridgeSize();
        bridgeState = bridgeMaker.makeBridge(size);
    }

    public void play() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.start(bridgeState, size);
    }


}
