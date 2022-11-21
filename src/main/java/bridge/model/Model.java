package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    public static List<String> bridge;
    public static List<String> upperBridgeMap = new ArrayList<>();
    public static List<String> lowerBridgeMap = new ArrayList<>();

    public static void clearBridgeMap() {
        upperBridgeMap.clear();
        lowerBridgeMap.clear();
    }
}
