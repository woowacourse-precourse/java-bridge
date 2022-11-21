package bridge.domain;

import java.util.List;

public class Bridge {

    private static List<String> bridge;

    public static void setBridge(List<String> bridge) {
        Bridge.bridge = bridge;
    }

    public static String getStepInBridge(int index) {
        return bridge.get(index);
    }

    public static int size() {
        return bridge.size();
    }
}
