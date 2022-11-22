package bridge.domain;

import bridge.BridgeNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private static List<String> bridge;
    private static List<String> upperBridge;
    private static List<String> lowerBridge;

    public Bridge(BridgeNumberGenerator bridgeNumberGenerator) {
        bridge = new BridgeMaker(bridgeNumberGenerator).makeBridge(User.getBridgeSize());
    }

    private static void resetUpperBridge() {
        upperBridge = new ArrayList<String>();
    }

    private static void resetLowerBridge() {
        lowerBridge = new ArrayList<String>();
    }

    public static List<String> getBridge() {
        return bridge;
    }

    public static void makeUpperBridge() {
        resetUpperBridge();
        List<String> userBridge = User.getUserMovingRecord();
        for (int stage = 0; stage < userBridge.size(); stage++) {
            String keyword = CalculationResult.calculateUpper(bridge.get(stage),
                    userBridge.get(stage));
            upperBridge.add(keyword);
        }
    }

    public static void makeLowerBridge() {
        resetLowerBridge();
        List<String> userBridge = User.getUserMovingRecord();
        for (int stage = 0; stage < userBridge.size(); stage++) {
            String keyword = CalculationResult.calculateLower(bridge.get(stage),
                    userBridge.get(stage));
            lowerBridge.add(keyword);
        }
    }

    public static List<String> getUpperBridge() {
        makeUpperBridge();
        return upperBridge;
    }

    public static List<String> getLowerBridge() {
        makeLowerBridge();
        return lowerBridge;
    }
}
