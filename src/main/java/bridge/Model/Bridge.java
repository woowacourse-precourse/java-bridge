package bridge.Model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static List<String> up = new ArrayList<>();
    private static List<String> down = new ArrayList<>();

    public void setUp(List<String> up) {
        Bridge.up = up;
    }

    public void setDown(List<String> down) {
        Bridge.down = down;
    }

    public List<String> getUp() {
        return up;
    }

    public List<String> getDown() {
        return down;
    }
}
