package bridge;

import bridge.Controller.GameController;
import bridge.Domain.BridgeMaker;

public class Application {

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        try {
            GameController gameController = new GameController(bridgeMaker());
            gameController.run();
        } catch (IllegalArgumentException e) {
            System.out.print(e.getMessage());
        }
    }


    public static BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    public static BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }
}
