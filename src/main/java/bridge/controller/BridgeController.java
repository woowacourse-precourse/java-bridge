package bridge.controller;

import bridge.service.BridgeService;

public class BridgeController {

    static BridgeService bridgeService = new BridgeService();

    public void gameStart(){
        bridgeService.bridgeGameStart();
    }

}
