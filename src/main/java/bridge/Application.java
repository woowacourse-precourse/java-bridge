package bridge;

import bridge.model.BridgeSize;
import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView input = new InputView();
        input.gameStart();
        String size = input.readBridgeSize();
        BridgeSize bridgeSize = new BridgeSize(size);
        System.out.println("bridgeSize = " + bridgeSize.getSize());
    }
}
