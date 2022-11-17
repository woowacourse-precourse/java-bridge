package bridge.controller;

import bridge.model.Bridge;
import bridge.type.ErrorType;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private InputView inputView = new InputView();
    private Bridge bridge = new Bridge();
    
    public void play() {
        OutputView.printStartGame();
        generateBridge();
    }

    public void generateBridge() {
        int size = 0;
        while (true) {
            try {
                size = inputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                inputView.printError(ErrorType.INPUT_ERROR_TYPE.getText());
            }
        }
        bridge.setBridge(size);
    }
}
