package bridge.config;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

public class Config {

    public BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

}
