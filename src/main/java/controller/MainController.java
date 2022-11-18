package controller;

import bridge.Bridge;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class MainController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public void run(){
        startGame();
        int bridgeSize = getBridgeSize();
        Bridge bridge = makeBridge(bridgeSize);
    }

    private Bridge makeBridge(int bridgeSize){
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridgeSize, bridge);
    }

    private void startGame(){
        outputView.printStartGame();
    }

    private int getBridgeSize() {
        printReceiveBridgeSize();
        int bridgeSize = -1;
        try {
            bridgeSize = readBridgeSize();
            BridgeMaker.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            getBridgeSize();
        }
        return bridgeSize;
    }


    private void printReceiveBridgeSize(){
        outputView.printReceiveBridgeSize();
    }

    private int readBridgeSize(){
        return inputView.readBridgeSize();
    }
}
