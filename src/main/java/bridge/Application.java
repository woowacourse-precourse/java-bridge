package bridge;

import bridge.domain.BridgeGame;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new OutputView().printStartMessage();
        new BridgeGame().runGame();
    }
}
