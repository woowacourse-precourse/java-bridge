package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.InputView;
import bridge.OutputView;
import java.util.List;

public class Controller {

    private InputView inputView= new InputView();
    private OutputView outputView = new OutputView();

    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    static private BridgeGame bridgeGame;
    public Controller() {
        setMap();
    }

    public void setMap(){
        int size = inputView.readBridgeSize();
        List<String> mapBridge = bridgeMaker.makeBridge(size);
    }

    public void play(){



    }



}
