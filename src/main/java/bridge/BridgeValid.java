package bridge;

import java.util.*;
public class BridgeValid {

    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final Bridge bridge = new Bridge();
    private final OutputView outputView = new OutputView();

    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();

    private int count = 1;
    private int stack = 0;

    public void useBridge() {
        bridge.matchBridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    public void loop() {
        for (upBridge.size(); checkRetry() && upBridge.size() < bridge.getBridgeSize(); ) {
            checkMoving(upBridge.size());
        }
    }

    public boolean checkRetry() {
        if (upBridge.contains("X") || downBridge.contains("X")) {
            String userRetry = checkRetryInput();
            if (!bridgeGame.retry(userRetry)) {
                return false;
            }
            setNumber();
        }
        return true;
    }



}
