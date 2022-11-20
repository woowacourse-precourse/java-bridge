package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.ui.InputView;

public class Application {

    private long gameCount = 1;
    private static final InputView INPUT_VIEW = new InputView();
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        Player player = new Player();
        initializeGame();
    }

    private static void initializeGame() {
        int bridgeLength = INPUT_VIEW.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeLength);
    }
}
