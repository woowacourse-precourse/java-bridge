package bridge;

import bridge.model.Bridge;
import bridge.model.Player;
import bridge.util.BridgeViewConstructor;

import java.util.List;

public class BridgeGame{
    private final Bridge bridge;
    private final Player player;

    public BridgeGame(int size){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(size));
        player = new Player();
    }

    private String constructBridge(){
        BridgeViewConstructor bridgeViewConstructor = new BridgeViewConstructor();
        return bridgeViewConstructor.constructBridge(player.getBridges(), bridge.getBridges());
    }
}