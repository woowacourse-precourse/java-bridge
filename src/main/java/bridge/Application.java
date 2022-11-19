package bridge;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeNumberGenerator BridgeNumberGenerator = null;
        BridgeMaker BridgeMaker = new BridgeMaker(BridgeNumberGenerator);
        List<String> Bridge = BridgeMaker.makeBridge(inputView.readBridgeSize());
        for (int i = 0; i <Bridge.size() ; i++) {
            System.out.print(Bridge.get(i));
        }
    }
}
