package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printStart();
        getBridge(getBridgeSize());
    }

    private int getBridgeSize() {
        int size = 0;
        try {
            size = inputView.readBridgeSize();
        } catch (IllegalArgumentException ex) {
            outputView.printMessage(ex.getMessage());
            getBridgeSize();
        }
        return size;
    }

    private void getBridge(int size) {
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);

    }
}
