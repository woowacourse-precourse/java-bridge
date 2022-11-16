package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.InputView;
import bridge.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private InputView inputView= new InputView();
    private OutputView outputView = new OutputView();
    private int size= 0;

    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private List<String> mapBridge = new ArrayList<>();
    static private BridgeGame bridgeGame;
    public Controller() {
        setMap();
    }

    public void setMap(){
        size = inputView.readBridgeSize();
        mapBridge = bridgeMaker.makeBridge(size);
    }

    /*public void play(){
        int idx=0;
        while(idx<size){
        }


    }*/



}
