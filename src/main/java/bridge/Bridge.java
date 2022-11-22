package bridge;

import bridge.constant.ErrorMessage;
import java.util.List;

public class Bridge {

    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public Bridge(int size) {
        isValidate(size);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }
    private void isValidate(int size) {
        if (!(size >= MIN_BRIDGE_SIZE && size <= MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_ERROR.toString());
        }
    }

    public int getSize() {
        return bridge.size();
    }

    public String getAnswerDirection(int index) {
        return bridge.get(index);
    }

    public void add(String element) {
        bridge.add(element);
    }

    public void clear() {
        bridge.clear();
    }

    public List<String> getBridge() {
        return bridge;
    }

}
