package bridge.controller;// @ author ninaaano

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.MapMaker;
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

    private void moveBridge(){
        BridgeGame bridgeGame = new BridgeGame(bridge);
        MapMaker mapMaker = new MapMaker();

        int move = 0;
        while(move < bridge.size()){
            OutputView.showInputMove(); // 이동할 칸 선택
            mapMaker.printMap(); // 맵을 보여준다
            move = move + 1; // 움직인다
        }
    }

}
