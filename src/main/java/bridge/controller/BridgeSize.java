package bridge.controller;

import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;
import bridge.model.Bridge;
import bridge.service.Valification;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeSize {

    private final InputView inputView = new InputView();
    private final Valification valification = new Valification();
    private final OutputView outputView = new OutputView();
    private final Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()));

    private int size;

    public void viewBridgeSize(){
        outputView.printRequestBridgeSize();
        size = inputView.readBridgeSize();
        valification.verifyBridgeSize(size);
        makeBridge();
    }

    private void makeBridge(){
        bridge.setBridge(size);
    }

    public int getSize(){
        return size;
    }
}
