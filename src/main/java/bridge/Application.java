package bridge;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeNumberGenerator BridgeNumberGenerator = null;
        BridgeMaker BridgeMaker = new BridgeMaker(BridgeNumberGenerator);
        int size = inputView.readBridgeSize();
        List<String> upBridge = BridgeMaker.makeBridge(size);
        List<String> downBridge = BridgeMaker.makeBridge(size);
        BridgeGame BridgeGame = new BridgeGame();
        int retryNum = 0;
        BridgeGame.game(size, retryNum, upBridge, downBridge);
    }
}
