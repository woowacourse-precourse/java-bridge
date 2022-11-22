package bridge;

import static bridge.BridgeGame.downstairsBridge;
import static bridge.BridgeGame.upstairsBridge;

import java.util.List;


public class Application {

    public static void main(String[] args) {

        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        gameController.bridgeGameProcess();
    }
}
