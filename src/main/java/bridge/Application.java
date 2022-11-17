package bridge;

import java.util.List;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();

        Bridge bridge = new Bridge(app.initializeBridge());
    }

    private List<String> initializeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
