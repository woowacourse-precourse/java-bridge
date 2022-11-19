package bridge;

import bridge.util.BridgeMaker;
import bridge.domain.GameManager;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        GameManager gameManager = new GameManager(bridgeMaker);
        gameManager.play();
    }
}
