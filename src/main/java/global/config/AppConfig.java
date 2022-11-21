package global.config;

import bridge.BridgeFactory;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.MessageFactory;
import bridge.view.MessageMaker;
import java.util.List;

public class AppConfig {
    public BridgeFactory bridgeFactory (){
        return new BridgeMaker(bridgeNumberGenerator());
    }

    public BridgeNumberGenerator bridgeNumberGenerator(){
        return new BridgeRandomNumberGenerator();
    }

    public MessageFactory messageFactory(final List<String> steps){
        return new MessageMaker(steps);
    }
}
