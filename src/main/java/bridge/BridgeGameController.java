package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgeGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private int count = 1;


    public void run() {

        outputView.printStart();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());

        BridgeGame bridgeGame = new BridgeGame(bridge);

        boolean isSuccess = crossBridge(bridge, bridgeGame);

        outputView.printResult(count, isSuccess);
    }

    private boolean crossBridge(List<String> bridge, BridgeGame bridgeGame) {
        if (!movingBridge(bridge, bridgeGame)) {//X라면
            if (bridgeGame.retry(inputView.readGameCommand())) {
                count++;
                return crossBridge(bridge, bridgeGame);
            }
            return false;
        }
        return true;
    }

    private boolean movingBridge(List<String> bridge, BridgeGame bridgeGame) {
        List<Map<String, Boolean>> list = new ArrayList<>();
        for (int i = 0; i < bridge.size(); i++) {
            if (!isMovingState(bridgeGame, list, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isMovingState(BridgeGame bridgeGame, List<Map<String, Boolean>> list, int index) {
        String moving = inputView.readMoving();
        boolean movingState = bridgeGame.move(index, moving);
        list.add(new HashMap<>() {{
            put(moving, movingState);
        }});
        outputView.printMap(list);
        return movingState;
    }
}
