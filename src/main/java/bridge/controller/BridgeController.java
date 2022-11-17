package bridge.controller;

import bridge.domain.Bridge;

public class BridgeController {
    public static void setBridgeInstance(Bridge bridge, int size) {
        bridge = new Bridge(size);
        // 이방법이 좋은지 return Bridge(size) 가 좋은지
    }
}
