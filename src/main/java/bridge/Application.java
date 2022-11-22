package bridge;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeGame;
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
성
        int start = controller.run(bridgeSize, bridgeGame);
        OutputView.printResult(GameStatus.currentStatus(start), bridgeGame.totalGameCount());
    }
}