package bridge;

import bridge.controller.BridgeGameManager;
import bridge.ioview.OutputView;

public class Application {

    private static final BridgeGameManager bridgeGameManager = new BridgeGameManager();

    public static void main(String[] args) {
        OutputView.startGame();
        try {
            bridgeGameManager.makeBridge();
            bridgeGameManager.crossBridge();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
