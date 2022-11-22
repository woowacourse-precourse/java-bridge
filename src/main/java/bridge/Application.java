package bridge;

import bridge.domain.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.service.BridgeGameService;
import bridge.view.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BridgeGameService bridgeGameService = new BridgeGameService();
        bridgeGameService.startBridgeGame();

        int bridgeSize = Integer.parseInt(new InputView().readBridgeSize());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> crossByBridge = bridgeMaker.makeBridge(bridgeSize);

        bridgeGameService = new BridgeGameService(crossByBridge);
        bridgeGameService.playBridgeGame();
    }
}
