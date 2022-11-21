package bridge.config;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

public class AppConfig {

    public static BridgeNumberGenerator selectNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

}
