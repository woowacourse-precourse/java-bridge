package bridge;

import controller.BridgeGameController;
import repository.BridgeRepository;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeRepository bridgeRepository = new BridgeRepository();
        BridgeGame bridgeGame = new BridgeGame(bridgeRepository);
        BridgeGameController bridgeGameController = new BridgeGameController(bridgeGame);

        bridgeGameController.play();
    }
}
