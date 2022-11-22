package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getBridgeOfIndex(int index) {
        return bridge.get(index); //유효하지 않은 index -> IndexOutOfBoundsException 반환
    }
}
