package bridge;

import bridge.domain.BridgeGame;
import bridge.views.InputView;
import bridge.views.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.gameStartMessage();
        bridgeGame.move();



    }
}
