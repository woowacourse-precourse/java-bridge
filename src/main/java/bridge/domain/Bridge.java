package bridge.domain;

import bridge.enums.Key;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Key> boxes; // 여러 개의 박스가 하나의 Bridge를 이루고 있음

    public Bridge(List<String> stringBridge) {
        this.boxes = new ArrayList<>();
        mapBridge(stringBridge);
    }

    private void mapBridge(List<String> stringBridge) {
        for (String string : stringBridge) {
            this.boxes.add(Key.valueOf(string));
        }
    }

    public int size() {
        return boxes.size();
    }

    public Key get(int index) {
        return boxes.get(index);
    }
}
