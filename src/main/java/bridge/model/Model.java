package bridge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * *bridge : randomly created bridge with length inputted by user<br>
 * *upperBridgeMap : the map represent current game state of upper bridge through on game rounds
 * *lowerBridgeMap : the map represent current game state of lower bridge through on game rounds
 */
public class Model {

    public static List<String> bridge;
    public static List<String> upperBridgeMap = new ArrayList<>();
    public static List<String> lowerBridgeMap = new ArrayList<>();

    public static void clearBridgeMap() {
        upperBridgeMap.clear();
        lowerBridgeMap.clear();
    }
}
