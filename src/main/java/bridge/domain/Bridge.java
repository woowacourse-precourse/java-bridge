package bridge.domain;

import bridge.validator.BridgeFormatValidator;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        BridgeFormatValidator.validate(bridge);
        this.bridge = bridge;
    }

    public boolean compareWithPosition(int position, String str) {
        return bridge.get(position).equals(str);
    }

    public int size() {
        return bridge.size();
    }
}
