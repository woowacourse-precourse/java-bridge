package bridge.domain;

import bridge.enums.Key;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Key> boxes; // 여러 개의 박스가 하나의 Bridge를 이루고 있음

    public Bridge(List<String> stringBridge) {
        this.boxes = mapBridge(stringBridge);
    }

    private List<Key> mapBridge(List<String> stringBridge) {
        List<Key> result = new ArrayList<>();
        for (String string : stringBridge) {
            result.add(Key.valueOf(string));
        }
        return result;
    }

    public int getSize() {
        return boxes.size();
    }

    public Key get(int index) {
        return boxes.get(index);
    }
}
