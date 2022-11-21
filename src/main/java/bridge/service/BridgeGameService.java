package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameService {
    private final BridgeMaker bridgeMaker;

    public BridgeGameService() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> initializeGame() {
        OutputView.printStart();
        return bridgeMaker.makeBridge(getSize());
    }

    private int getSize() {
        int size = 0;
        while (size == 0) {
            try {
                OutputView.printInputBridgeSize();
                size = InputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return size;
    }
}
