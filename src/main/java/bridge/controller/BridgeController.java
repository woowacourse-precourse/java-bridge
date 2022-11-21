package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.dto.BridgeDto;
import bridge.exception.NotNumericException;
import bridge.service.BridgeService;
import bridge.utils.StringUtils;
import bridge.validator.BridgeSizeValidator;
import bridge.view.InputView;

public class BridgeController {
    private final static BridgeService bridgeService = new BridgeService();

    public void generateBridge() {
        String input = InputView.readBridgeSize();

        try {
            initBridge(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            generateBridge();
        }
    }

    private void initBridge(String input) {
        if (!StringUtils.isNumeric(input)) {
            throw new NotNumericException();
        }
        int bridgeSize = Integer.parseInt(input);
        BridgeSizeValidator.validateBridgeSize(bridgeSize);

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeDto bridgeDto = BridgeDto.from(bridgeMaker.makeBridge(bridgeSize));
        bridgeService.initBridge(bridgeDto);
    }
}
