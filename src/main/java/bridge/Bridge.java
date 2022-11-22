package bridge;

import java.util.List;

public class Bridge {
    private List<String> bridge;
    InputView inputView = new InputView();

    public Bridge() {
        int size = inputView.readBridgeSize();
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }

    public String getIndex(int index) {
        return bridge.get(index);
    }

    public int getSize() {
        return bridge.size();
    }
}
