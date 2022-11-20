package bridge;

import java.util.List;

import static bridge.view.InputView.readBridgeSize;

public class Application {

    public static void main(String[] args) {
        try {
            int bridgeSize = readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
