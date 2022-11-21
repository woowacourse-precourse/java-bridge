package bridge.controller;

import bridge.view.InputView;

public class BridgeController {

    private static final InputView inputView = new InputView();

    public void init() {

        int inputSize = getBridgeSize();
//        bridges = makeRandomBridges(inputSize);
//        triedNumber = getTriedNumber(inputSize);
//        printResult();
    }

    private int getBridgeSize() {
        return inputView.readBridgeSize();
    }

}

