package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        inputView.startMsg();

        int bridgeSize = inputView.readBridgeSize();

        List<String> firstBridge = bridgeMaker.makeBridge(bridgeSize);
        List<String> secondBridge = bridgeMaker.makeSecondBridge(firstBridge);

        String move = inputView.readMoving();


    }
}
