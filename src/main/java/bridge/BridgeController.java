package bridge;

import java.util.List;

public class BridgeController {

    public void run(InputView inputView, int bridgeSize, List<String> randomBridge) {
        BridgeIndex index = new BridgeIndex();
        int gameCount = 1;
        boolean gameEndButton = false;
        BridgeResults bridgeResults = new BridgeResults();
        while (!index.endGame(bridgeSize) && !gameEndButton) {
            BridgeLocationStatus bridgeLocationStatus = inputView.readMoving();
            boolean compareBridgeLocationResult = bridgeLocationStatus.compareBridgeLocation(randomBridge, index);
            bridgeResults.report(bridgeLocationStatus, compareBridgeLocationResult);
        }
    }
}
