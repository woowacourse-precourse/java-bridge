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
        String type = bridgeType.name();

        if (survive) {
            return drawSurviveBridgeMap(type);
        }
        return drawDeadBridgeMap(type);
    }

    private String drawSurviveBridgeMap(String type) {
        return drawMapWithoutTail(type) + withSurviveTail(type);
    }

    private String drawDeadBridgeMap(String type) {
        return drawMapWithoutTail(type) + withDeadTail(type);
    }

    private String drawMapWithoutTail(String type) {
        StringBuilder mapBuilder = new StringBuilder();
        for (int i = 0; i < bridge.size() - 1; i++) {
            if (bridge.get(i).equals(type)) {
                mapBuilder.append(BridgeConstant.RIGHT_WAY).append(BridgeConstant.BRIDGE_CHAIN);
            }
            if (!bridge.get(i).equals(type)) {
                mapBuilder.append(BridgeConstant.AVOID_WAY).append(BridgeConstant.BRIDGE_CHAIN);
            }
        }
        return mapBuilder.toString();
    }

    private String withSurviveTail(String type) {
        StringBuilder mapBuilder = new StringBuilder();
        if (bridge.get(bridge.size() - 1).equals(type)) {
            return mapBuilder.append(BridgeConstant.RIGHT_WAY).toString();
        }
        return mapBuilder.append(BridgeConstant.AVOID_WAY).toString();
    }

    private String withDeadTail(String type) {
        StringBuilder mapBuilder = new StringBuilder();
        if (bridge.get(bridge.size() - 1).equals(type)) {
            return mapBuilder.append(BridgeConstant.AVOID_WAY).toString();
        }
        return mapBuilder.append(BridgeConstant.WRONG_WAY).toString();
    }

    private String boxing(String str) {
        return BridgeConstant.LEFT_BOX + str + BridgeConstant.RIGHT_BOX;
    }
}
