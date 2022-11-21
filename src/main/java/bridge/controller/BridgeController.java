package bridge.controller;

import bridge.service.BridgeService;

public class BridgeController {

    public static void initBridgeSize() {
        BridgeService.getInitBridgeSize();
    }

    public static void makeBridge() {
        BridgeService.makeBridge();
    }

    public static void initMoveRow() {
        BridgeService.getInitMoveRow();
    }

    public static void moveBridge() {
        BridgeService.moveBridge();
    }

    public static void compareMove() {
        BridgeService.compareMoveBridge();
    }

    public static void viewBridge() {
        BridgeService.viewBridge();
    }
}
