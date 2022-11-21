package bridge.domain;

import java.util.List;

public class BridgeMap {

    private final List<String> bridge;
    private final boolean survive;

    private BridgeMap(Result result) {
        this.bridge = result.getBridge();
        this.survive = result.isSurvive();
    }

    public static BridgeMap of(Result result) {
        return new BridgeMap(result);
    }

    @Override
    public String toString() {
        String upperBridgeMap = drawMapOf(BridgeType.U);
        String lowerBridgeMap = drawMapOf(BridgeType.D);

        return boxing(upperBridgeMap)
            + "\n"
            + boxing(lowerBridgeMap);
    }

    private String drawMapOf(BridgeType bridgeType) {
        StringBuilder mapBuilder = new StringBuilder();
        String type = bridgeType.name();

        drawMapWithoutTail(mapBuilder, type);
        if (survive) {
            return withSurviveTail(mapBuilder, type);
        }
        return withDeadTail(mapBuilder, type);
    }

    private void drawMapWithoutTail(StringBuilder mapBuilder, String type) {
        for (int i = 0; i < bridge.size() - 1; i++) {
            if (bridge.get(i).equals(type)) {
                mapBuilder.append(" O ").append("|");
            }
            if (!bridge.get(i).equals(type)) {
                mapBuilder.append("   ").append("|");
            }
        }
    }

    private String withSurviveTail(StringBuilder mapBuilder, String type) {
        if (bridge.get(bridge.size() - 1).equals(type)) {
            return mapBuilder.append(" O ").toString();
        }
        return mapBuilder.append("   ").toString();
    }

    private String withDeadTail(StringBuilder mapBuilder, String type) {
        if (bridge.get(bridge.size() - 1).equals(type)) {
            return mapBuilder.append("   ").toString();
        }
        return mapBuilder.append(" X ").toString();
    }

    private String boxing(String str) {
        return "[" + str + "]";
    }
}
