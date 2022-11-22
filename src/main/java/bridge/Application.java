package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.StartGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static int totalTrial;

    public static void main(String[] args) {
        int size = initSet();
        BridgeGame bridgeGame = new BridgeGame(size);
        while (StartGame.startGame(bridgeGame, size)) {
            if (bridgeGame.finish) {
                break;
            }
        }
        OutputView.printResult(bridgeGame);
    }

    public static int initSet() {
        OutputView.printStart();
        OutputView.printRequestSize();
        int size = InputView.readBridgeSize();
        totalTrial = 1;
        return size;
    }
}
