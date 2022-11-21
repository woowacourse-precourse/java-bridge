package bridge.controller;

import bridge.model.BridgeMaker;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {

    InputView inputview = new InputView();
    OutputView outputView = new OutputView();
    private BridgeMaker bridgeMaker;

    private List<String> randomBridge;
    public void startGame(){
        outputView.printGameStartMessage();

        makeBridge();


    }

    public List<String> makeBridge() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = inputview.readBridgeSize();
        randomBridge = bridgeMaker.makeBridge(size);

        return randomBridge;
    }

}
