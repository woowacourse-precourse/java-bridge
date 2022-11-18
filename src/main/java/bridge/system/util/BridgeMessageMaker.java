package bridge.system.util;

import java.util.List;

public class BridgeMessageMaker {

    public static final String BRIDGE_START = "[";

    public String makeBridgeMessage(List<Boolean> answers) {
        StringBuilder upBridgeBuilder = new StringBuilder();
        StringBuilder downBridgeBuilder = new StringBuilder();

        makeStartOfBridge(upBridgeBuilder, downBridgeBuilder);

        return makeResult(upBridgeBuilder, downBridgeBuilder);
    }

    private String makeResult(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder) {
        return upBridgeBuilder.toString() + System.lineSeparator() + downBridgeBuilder.toString();
    }

    private void makeStartOfBridge(StringBuilder upBridgeBuilder, StringBuilder downBridgeBuilder) {
        upBridgeBuilder.append(BRIDGE_START);
        downBridgeBuilder.append(BRIDGE_START);
    }
}
