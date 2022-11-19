package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.view.InputView;

import java.util.ArrayList;

public class BridgeGameService {

    public static Bridge initBridge() {
        String bridgeSize;
        do {
            bridgeSize = InputView.readBridgeSize();
        } while (bridgeSize == "error");
        Bridge bridge = BridgeService.makeBridge(Integer.parseInt(bridgeSize));
        return bridge;
    }

    public static GameResult initGameResult() {
        return new GameResult(new ArrayList<>(), new ArrayList<>());
    }


    public static int initTryCount() {
        return 1;
    }

    public static int initCount() {
        return 0;
    }
}
