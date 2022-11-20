package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;

public class BridgeGameService {

    private BridgeGame bridgeGame;

    public void makeBridge(int number) {
        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        this.bridgeGame = BridgeGame.of(number, randomGenerator);
    }
}
