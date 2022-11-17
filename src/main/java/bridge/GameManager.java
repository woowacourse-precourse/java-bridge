package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameManager {

    private GameManager() {

    }

    public static void execute() {
        GameManager gameManager = new GameManager();
        gameManager.startGame();
    }

    private void startGame() {
        Bridge bridge = this.buildBridge();

    }

    private Bridge buildBridge() {
        int bridgeSize = InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

}
