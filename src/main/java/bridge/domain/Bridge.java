package bridge.domain;

import bridge.enums.Key;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Key> bridge;

    public Bridge(List<String> stringBridge) {
        this.bridge = new ArrayList<>();
        mapBridge(stringBridge);
    }

    private void mapBridge(List<String> stringBridge) {
        for (String string : stringBridge) {
            this.bridge.add(Key.valueOf(string));
        }
    }

    public int size() {
        return bridge.size();
    }

    public Key get(int index) {
        return bridge.get(index);
    }
}
