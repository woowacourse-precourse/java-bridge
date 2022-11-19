package bridge.service;


import bridge.view.InputView;
import bridge.view.OutputView;

public class InputViewService {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public int inputBridgeSize() {
        try {
            outputView.printChoiceBridgeSize();
            int bridgeSize = inputView.readBridgeSize();
            return bridgeSize;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return inputBridgeSize();
    }
}
