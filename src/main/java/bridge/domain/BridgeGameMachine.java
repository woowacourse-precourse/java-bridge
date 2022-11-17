package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.input.InputView;
import java.util.List;

public class BridgeGameMachine {

    public void run() {
        InputView inputView = new InputView();
        int bridgeLength = inputView.readBridgeSize();

        BridgeRandomNumberGenerator randomGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomGenerator);
        List<String> strings = bridgeMaker.makeBridge(bridgeLength);


    }
}
