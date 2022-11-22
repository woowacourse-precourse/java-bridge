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
        for (int i = 0; i < bridge.size(); i++) {
            if (other.getBridge().get(i).equals(this.bridge.get(i)))
                continue;
            return false;
        }
        return true;
    }


}
