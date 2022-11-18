package bridge.controller;

import bridge.exception.NotNumericException;
import bridge.utils.StringUtils;
import bridge.validator.BridgeSizeValidator;
import bridge.view.InputView;

public class BridgesController {
    public void generateBridge() {
        String input = InputView.readBridgeSize();

        try {
            if (!StringUtils.isNumeric(input)) {
                throw new NotNumericException();
            }
            int bridgeSize = Integer.parseInt(input);
            BridgeSizeValidator.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            generateBridge();
        }
    }
}
