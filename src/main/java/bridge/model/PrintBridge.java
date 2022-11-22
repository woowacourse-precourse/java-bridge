package bridge.model;

import java.util.List;

public class PrintBridge {

    private static final String JOIN_DELIMITER = "|";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";

    public String generatePrintUpShape(List<String> playerBridgeUpShape) {
        String joinedPlayerBridgeUpShape = String.join(JOIN_DELIMITER, playerBridgeUpShape);
        return OPEN_BRACKET + joinedPlayerBridgeUpShape + CLOSE_BRACKET;
    }

    public String generatePrintDownShape(List<String> playerBridgeDownShape) {
        String joinedPlayerBridgeDownShape = String.join(JOIN_DELIMITER, playerBridgeDownShape);
        return OPEN_BRACKET + joinedPlayerBridgeDownShape + CLOSE_BRACKET;
    }
}
