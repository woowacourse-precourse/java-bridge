package bridge.service;

import bridge.BridgeNumberGenerator;

public interface BridgeGameService {

    Bridge createBridge(int bridgeSize, BridgeNumberGenerator generator);
}
