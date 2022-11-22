package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.Player;
import bridge.type.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView.printGameStart();
        int bridgeSize = InputView.readBridgeSize();

        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        BridgeGameController controller = new BridgeGameController(new Player(), bridgeGame);

        int start = controller.run(bridgeSize);
        OutputView.printResult(GameStatus.currentStatus(start), bridgeGame.totalGameCount());
    }
}