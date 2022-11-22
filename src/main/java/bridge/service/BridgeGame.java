package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class BridgeGame {

    public List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> builtbridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(builtbridge);
        return builtbridge;
    }

    public boolean move(String userMove, int location, List<String> builtBridge) {

        if (userMove.equals(builtBridge.get(location))) {
            return true;
        }
        return false;
    }

    public boolean retry(String command) {

        if (command.equals("Q")) {
            return false;
        }
        if (command.equals("R")) {
            return true;
        }
        return false;
    }

}
