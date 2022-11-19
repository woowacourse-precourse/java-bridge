package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.printGameStart();
        String size = inputView.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(size);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());
        System.out.println("bridge = " + bridge);
        new Bridge(bridge);
    }
}
