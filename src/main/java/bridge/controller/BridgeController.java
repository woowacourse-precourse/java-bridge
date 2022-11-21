package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeMaker;
import bridge.view.InputView;

import java.util.List;

public class BridgeController {

    private static final InputView inputView = new InputView();
    private static List<String> bridges;
    private static Boolean trueOrFalse = true;

    public void init() {

        int inputSize = getBridgeSize();
        bridges = makeRandomBridges(inputSize);

        while (trueOrFalse) {
            String inputMoving = inputView.readMoving();
//            getTriedNumber();
        }
//        triedNumber = getTriedNumber(inputSize);
//        printResult();
    }

    private int getBridgeSize() {
        return inputView.readBridgeSize();
    }

    private List<String> makeRandomBridges(int inputSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(inputSize);
    }

}

