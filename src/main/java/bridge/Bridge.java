package bridge;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private List<String> bridge;
    private int pos = 0;

    public Bridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = InputView.readBridgeSize();
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public boolean matchBridge(String uOrD) {
        if(bridge.get(pos).equals(uOrD)) {
            pos++;
            return true;
        }
        return false;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public boolean checkResult() {
        return bridge.size() == pos+1;
    }
}
