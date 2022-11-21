package bridge;

import bridge.domain.BridgeGameStarter;
import bridge.domain.bridgegame.BridgeGameController;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameStarter bridgeGameStarter = new BridgeGameController();
        bridgeGameStarter.start();
    }
}
