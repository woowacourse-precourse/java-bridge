package bridge.controller;// @ author ninaaano

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.*;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private List<String> bridge = new ArrayList<>();
    BridgeGame bridgeGame;
    private int count = 0;
    private boolean gameResult = true;

    public BridgeGameController(){
        try {
            OutputView.showStartMessage();
            createBridge();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void bridgeGameSet(){
        bridgeGame = new BridgeGame(bridge);
    }

    private void createBridge(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        OutputView.showInputBridgeLength();
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }

}
