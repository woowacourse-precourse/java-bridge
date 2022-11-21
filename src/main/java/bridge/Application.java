package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int size;
        Announcement.start();
        size = InputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        // TODO: 프로그램 구현
    }
}
