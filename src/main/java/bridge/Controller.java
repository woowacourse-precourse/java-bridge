package bridge;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<String> bridge = new ArrayList<>();

    // TODO: 다리를 생성한다.
    public void createBridge(){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        OutputView.printInputLengthOfBridge();
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }
}
