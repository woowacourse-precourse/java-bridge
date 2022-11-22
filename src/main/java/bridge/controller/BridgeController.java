package bridge.controller;

import bridge.service.BridgeService;

public class BridgeController {

    public static int initBridgeSize() {
        return BridgeService.getInitBridgeSize();
    }

    public static void makeBridge(int inputSize) {
        BridgeService.makeBridge(inputSize);
    }

    public static void initMoveRow() {
        BridgeService.getInitMoveRow();
    }

    public static void compareMove() {
        BridgeService.compareMoveBridge();
    }

}
