package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int len = new InputView().readSize();
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(len);
        new BridgeGame(new InputView(), new OutputView(), bridge).move(1);
    }
}
