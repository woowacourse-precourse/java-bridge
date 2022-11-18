package bridge.controller;

import bridge.util.MessageUtil;
import bridge.util.ParserUtil;
import bridge.util.ValidationUtil;
import bridge.view.InputView;

public class InputController {

    public int getBridgeSize() {
        while(true) {
            try {
                return getAndParseBridgeSizeInput();
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getAndParseBridgeSizeInput() {
        MessageUtil.requestBridgeSize();
        String bridgeSizeInput = InputView.readBridgeSize();
        ParserUtil.parseBridgeSize(bridgeSizeInput);
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        return bridgeSize;
    }

}
