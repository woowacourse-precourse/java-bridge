package bridge;

import java.util.List;

public class GameController {
    public List<String> makeBridgeOfSize() {
        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRanNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRanNumberGenerator);

        return bridgeMaker.makeBridge(size);
    }

    public


}
