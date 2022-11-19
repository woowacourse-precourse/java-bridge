package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            int len = new InputView().readSize();
            List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(len);
            new BridgeGame().move(bridge, 1);
        } catch (IllegalArgumentException e) {
        }
    }
}
