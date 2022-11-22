package bridge;

import bridge.model.Bridge;
import bridge.model.Player;

public class BridgeGame{
    private final Bridge bridge;
    private final Player player;

    public BridgeGame(int size){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(size));
        player = new Player();
    }
}