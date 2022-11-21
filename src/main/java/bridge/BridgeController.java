package bridge;

import java.util.List;

public class BridgeController {

    private static final String INPUT_MOVING_LOCATION_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public void run(InputView inputView, int bridgeSize, List<String> randomBridge) {
        BridgeIndex index = new BridgeIndex();
        int gameCount = 1;
        boolean gameEndButton = false;
        BridgeResults bridgeResults = new BridgeResults();
        while (!index.endGame(bridgeSize) && !gameEndButton) {
            System.out.println(INPUT_MOVING_LOCATION_MESSAGE);
            BridgeLocationStatus bridgeLocationStatus = inputView.readMoving();
            boolean compareBridgeLocationResult = bridgeLocationStatus.compareBridgeLocation(randomBridge, index);
        }
    }
}
