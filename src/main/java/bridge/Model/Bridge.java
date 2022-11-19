package bridge.Model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    public static final Bridge bridge = new Bridge();
    private static List<String> up = new ArrayList<>();
    private static List<String> down = new ArrayList<>();

    public void updateUp(String up) {
        Bridge.up.add(up);
    }

    public void updateDown(String down) {
        Bridge.down.add(down);
    }

    public List<String> getUp() {
        return up;
    }

    public List<String> getDown() {
        return down;
    }
}
