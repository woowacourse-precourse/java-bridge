package controller;

import bridge.Bridge;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class MainController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void run(){
        startGame();
        Bridge bridge = getBridgeContainBridgeSize();

    }

    public Bridge makeBridge(int bridgeSize){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridgeSize, bridge);
    }

    private void startGame(){
        outputView.printStartGame();
    }

    public Bridge getBridgeContainBridgeSize(){
        printReceiveBridgeSize();
        Bridge bridge = validateBridgeSize();
        return bridge;
    }

    private Bridge validateBridgeSize() {
        Bridge bridge = null;
        try {
            int bridgeSize = readBridgeSize();
            bridge = new Bridge(bridgeSize);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            getBridgeContainBridgeSize();
        }
        return bridge;
    }


    private void printReceiveBridgeSize(){
        outputView.printReceiveBridgeSize();
    }

    private int readBridgeSize(){
        return inputView.readBridgeSize();
    }
}
