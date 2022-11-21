package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.gameStatus;
import bridge.ui.InputView;

public class Application {

    public static void main(String[] args) {
        InputView input = new InputView();

        int size = input.readBridgeSize();

        Bridge bridge = new Bridge(size);
        BridgeGame game = new BridgeGame(bridge);

        while (game.currentStatus == gameStatus.CONTINUE) {
            String direction = input.readMoving();
            game.move(direction);
        }
    }
}
