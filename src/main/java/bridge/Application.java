package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.Initialization;
import bridge.domain.StartGame;
import bridge.view.OutputView;

public class Application {

    public static int totalTrial;

    public static void main(String[] args) {
        int size = Initialization.init();
        BridgeGame bridgeGame = new BridgeGame(size);
        while (StartGame.startGame(bridgeGame)) {
            if (bridgeGame.movingTurn == size) {
                bridgeGame.success = true;
                break;
            }
        }
        OutputView.printResult(bridgeGame);
    }
}
