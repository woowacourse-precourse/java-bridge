package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeCell;
import bridge.BridgeNumberGenerator;
import bridge.domain.Command;

public interface BridgeGameService {

    Bridge createBridge(int bridgeSize, BridgeNumberGenerator generator);
    boolean moveBridge(BridgeCell cell);
    String createMap();
    boolean retryGame(Command command);
}
