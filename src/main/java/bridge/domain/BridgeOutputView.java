package bridge.domain;

public class BridgeOutputView {

    private static String PASS = " O ", FAIL = " X ", NONE = "   ", divider = "|", START = "[", END = "]";
    private static StringBuilder upperStringBuilder;
    private static StringBuilder lowerStringBuilder;

    public static String bridgePrint(Bridge bridge) {
        init();
        for (int i = 0; i < bridge.getPositionOnBridge(); ++i) {
            String bridgeElement = bridge.getBridge().get(i);
            if (bridgeElement.equals("U")) {
                upperCase(bridge, i);
            }
            if (bridgeElement.equals("D")) {
                lowerCase(bridge, i);
            }
            afterTreat(bridge, i);
        }
        return upperStringBuilder.append("\n").append(lowerStringBuilder).toString();
    }

    private static void init() {
        upperStringBuilder = new StringBuilder(START);
        lowerStringBuilder = new StringBuilder(START);
    }

    private static void afterTreat(Bridge bridge, int index) {
        if (isEnd(bridge, index)) {
            upperStringBuilder.append(END);
            lowerStringBuilder.append(END);
            return;
        }
        upperStringBuilder.append(divider);
        lowerStringBuilder.append(divider);
    }

    private static void upperCase(Bridge bridge, int index) {
        if (bridge.getBridgeGameState() == BridgeGameState.FAIL && isEnd(bridge, index)) {
            upperStringBuilder.append(NONE);
            lowerStringBuilder.append(FAIL);
            return;
        }
        upperStringBuilder.append(PASS);
        lowerStringBuilder.append(NONE);
    }

    private static void lowerCase(Bridge bridge, int index) {
        if (bridge.getBridgeGameState() == BridgeGameState.FAIL && isEnd(bridge, index)) {
            upperStringBuilder.append(FAIL);
            lowerStringBuilder.append(NONE);
            return;
        }
        upperStringBuilder.append(NONE);
        lowerStringBuilder.append(PASS);
    }

    private static boolean isEnd(Bridge bridge, int index) {
        return index == bridge.getPositionOnBridge() - 1;
    }
}
