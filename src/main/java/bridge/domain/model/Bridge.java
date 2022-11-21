package bridge.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private static final List<String> bridge = new ArrayList<>();

    public Bridge() {

    }

    public Bridge(List<String> setBridge) {
        Bridge.bridge.addAll(setBridge);
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getSize() {
        return getBridge().size();
    }

    public boolean isValid(int index, String where) {
        validate(index);
        return getBridge().get(index).equals(where);
    }

    private void validate(int index) throws IllegalArgumentException {
        if (getSize() <= index) {
            throw new IllegalArgumentException("[ERROR] have No Bridge Information");
        }
    }
}
