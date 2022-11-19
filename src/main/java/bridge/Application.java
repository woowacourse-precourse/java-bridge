package bridge;

import bridge.model.Bridge;
import bridge.model.BridgeSize;
import bridge.model.Direction;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.printGameStart();
        String size = inputView.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(size);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize()));
        Direction direction = Direction.fromInput(inputView.readDirection());
        System.out.println(direction);
    }
}
