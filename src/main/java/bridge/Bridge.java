package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public List<String> getBridge() {
        return bridge;
    }

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void add(String s) {
        this.bridge.add(s);
    }
    public boolean equals(Bridge other) {
        boolean isEqual = true;
        for (int i = 0; i < bridge.size(); i++) {
            isEqual = checkIdxValue(i, other);
        }
        return isEqual;
    }
    private boolean checkIdxValue(int idx, Bridge other){
        return other.bridge.get(idx).equals(bridge.get(idx));
    }


}
