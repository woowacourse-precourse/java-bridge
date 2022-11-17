package bridge;

import java.util.List;

public class BridgeController {

    public List<String> doBridgeMake(){
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        return bridgeMaker.makeBridge(bridgeSize);
    }

}
