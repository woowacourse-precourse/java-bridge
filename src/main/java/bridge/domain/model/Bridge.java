package bridge.domain.model;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean isValid(int index, String where) {
        return getBridge().get(index).equals(where);
    }

    public int getSize() {
        return getBridge().size();
    }
}
