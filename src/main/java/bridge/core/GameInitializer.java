package bridge.core;

import bridge.domain.Bridge;

import java.util.List;

public class GameInitializer {

    public BridgeGame init(String bridgeLength) {
        BridgeMaker bridgeMaker = BridgeMaker.getBridgeMaker();
        List<String> bridgeMap = bridgeMaker.makeBridge(Integer.valueOf(bridgeLength));
        Bridge bridge = new Bridge(bridgeMap);
        GameStatusOperator gameStatusOperator = GameStatusOperator.initGameStatusOperator();
        return new BridgeGame(bridge, gameStatusOperator);
    }
}
