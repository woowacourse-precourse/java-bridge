package bridge;

import bridge.model.BridgeSize;
import bridge.view.InputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView input = new InputView();
        input.gameStart();
        String size = input.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(size);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());
        System.out.println("bridge = " + bridge);
    }
}
