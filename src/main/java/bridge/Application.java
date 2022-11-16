package bridge;

import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.move(0, bridgeList, 0, "");
    }
}
