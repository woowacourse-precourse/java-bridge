package bridge.bridge;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

public interface BridgeContainer {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
}
