package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private final int size;

    public Bridge(List<String> bridge, int size) {
        this.bridge = bridge;
        this.size = size;
    }

    public boolean checkToMove(int position, String moveTo) {
        return bridge.get(position).equals(moveTo);
    }

    public int getSize() {
        return this.size;
    }
}
