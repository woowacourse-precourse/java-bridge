package global.config;

import bridge.BridgeFactory;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

public class AppConfig {
    public BridgeFactory bridgeFactory (){
        return new BridgeMaker(bridgeNumberGenerator());
    }

    public BridgeNumberGenerator bridgeNumberGenerator(){
        return new BridgeRandomNumberGenerator();
    }
}
