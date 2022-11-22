package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<Key> boxes;

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
