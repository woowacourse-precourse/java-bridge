package game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class Controller {

    public void run(int bridgeLength) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);
        System.out.println(bridge);
        BridgeGame bridgeGame = new BridgeGame();
        for (int stage = 0; stage < bridgeLength; stage++) {
            stage = bridgeGame.play(bridge, stage);
        }
    }
}
