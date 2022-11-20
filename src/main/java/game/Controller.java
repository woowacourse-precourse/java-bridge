package game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Controller {

    public void run(int bridgeLength) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);
        System.out.println(bridge);
    }
}
