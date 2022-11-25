package controller;

import model.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import util.Constants;
import view.InputView;
import view.OutputView;

import java.util.List;

public class BridgeGameController {
    private static int count = Constants.ZERO;
    private final InputView inputView;
    private List<String> bridge;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public BridgeGameController() {
        inputView = new InputView();
    }

    public void run() {
        prepareBridgeGame();
        startBridgeGame();
    }

    private void prepareBridgeGame() {
        OutputView.printStartBridgeGame();
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    private void startBridgeGame() {
        while(true) {
            String inputStatus = inputView.readMoving();
            if (BridgeGame.move(inputStatus, bridge, count++)) {break;}
        }
    }

    public static void setCount() {
        count = Constants.ZERO;
    }

}
