package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int len = inputView.readSize();
        List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(len);
        new BridgeGame(inputView, new OutputView(), bridge).move(1);
    }
}
