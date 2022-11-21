package bridge.service;

import bridge.BridgeNumberGenerator;
import bridge.domain.Bridge;

public interface BridgeGameService {

    Bridge createBridge(int bridgeSize, BridgeNumberGenerator generator);
}
