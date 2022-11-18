package global.config;

import bridge.BridgeFactory;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

public class AppConfig {
    public BridgeFactory bridgeFactory (){
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
