package bridge;

import java.util.List;

public class Player {

    private final InputView inputView = new InputView();

    public List<String> makeBridge(){
        int bridgeSize = getSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }

    private int getSize(){
        return inputView.readBridgeSize();
    }
}
