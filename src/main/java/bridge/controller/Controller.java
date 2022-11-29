package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.Validate;
import bridge.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private InputView inputView = new InputView();
    private BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private List<String> bridgeState = new ArrayList<>();
    private Validate validate = new Validate();
    private int size = 0;


    public Controller() {
        setBridge();
    }

    public void setBridge() {
        size = inputView.readBridgeSize(validate);
        bridgeState = bridgeMaker.makeBridge(size);
    }

    public void play() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.start(bridgeState, size);
    }


}
