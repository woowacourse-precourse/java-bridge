package bridge.model;

import java.util.List;

public class Comparison {

    public static boolean comparisonSpace(String input, List<String> bridgeResult) {
        return input.equals(bridgeResult.get(BridgeGame.moveIndex));
    }
}
