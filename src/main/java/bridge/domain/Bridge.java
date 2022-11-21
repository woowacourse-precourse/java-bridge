package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private static List<String> bridge;
    private static List<String> upperBridge;
    private static List<String> lowerBridge;
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    public Bridge() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridge = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(User.getBridgeSize());
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
        for (int i = 0; i < userBridge.size(); i++) {
            String keyword = CalculationResult.calculateUpper(bridge.get(i), userBridge.get(i));
            upperBridge.add(keyword);
        }
    }

    public static void makeLowerBridge() {
        resetLowerBridge();
        List<String> userBridge = User.getUserMovingRecord();
        for (int i = 0; i < userBridge.size(); i++) {
            String keyword = CalculationResult.calculateLower(bridge.get(i), userBridge.get(i));
            lowerBridge.add(keyword);
        }
    }
}
