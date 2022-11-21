package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.Initialization;
import bridge.domain.StartGame;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    public static int size;
    public static List<String> bridge;
    public static int movingTurn = 0;
    public static boolean success;

    public static void main(String[] args) {
        BridgeGame bridgeGame = Initialization.init();
        while (StartGame.startGame(bridgeGame)) {
            if (movingTurn == size) {
                success = true;
                break;
            }
        }
        OutputView.printResult(bridgeGame);
    }
}
