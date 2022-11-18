package bridge.controller;

import bridge.constant.ViewStatus;
import bridge.service.BridgeService;
import bridge.utils.InputParser;

public class BridgeGameController {

    private final BridgeService bridgeService;

    public BridgeGameController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    public ViewStatus makeBridge(String size) {
        try {
            return bridgeService.makeBridge(InputParser.parseToInteger(size));
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return ViewStatus.DETERMINE_BRIDGE_SIZE;
        }
    }
}
