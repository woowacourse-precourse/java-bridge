package bridge;

import bridge.domain.BridgeGame;
import bridge.exception.BridgeIllegalArgumentException;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
            outputView.printGameStart();
            BridgeGame bridgeGame = new BridgeGame();
            do {
                bridgeGame.playGame();
            } while (bridgeGame.retry());

            bridgeGame.end();
    }
}
