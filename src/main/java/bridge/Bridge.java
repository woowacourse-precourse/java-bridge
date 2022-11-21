package bridge;

import java.util.Collections;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int pos = -1;

    public Bridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = InputView.readBridgeSize();
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public boolean matchBridge(String uOrD) {
        increasePos();
        return bridge.get(pos).equals(uOrD);
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public boolean checkResult() {
        return bridge.size() == pos+1;
    }
    public void increasePos() {
        this.pos++;
    }
    public void decreasePos() {
        this.pos--;
    }
}
