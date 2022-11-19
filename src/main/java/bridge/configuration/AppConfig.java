package bridge.configuration;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class AppConfig {

    public static BridgeMaker bridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
