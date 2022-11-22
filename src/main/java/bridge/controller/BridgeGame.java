package bridge.controller;

import bridge.service.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.service.BridgeService;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    User user = new User();
    Bridge bridge;

    public void initGame(String size){
        int bridgeLength = BridgeService.validateBridgeLength(size);

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> resultBridge = bridgeMaker.makeBridge(bridgeLength);

        bridge = new Bridge(bridgeLength,resultBridge);
    }


}
