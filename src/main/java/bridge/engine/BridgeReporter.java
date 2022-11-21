package bridge.engine;

import java.util.List;

public class BridgeReporter {

    private String separator;

    public BridgeReporter(String separator) {
        this.separator = separator;
    }

    public String reportBridge(List<String> bridge, List<String> userDirection) {
        return renderUpBridge(bridge, userDirection) + "\n" + renderDownBridge(bridge, userDirection);
    }

    private String renderUpBridge(List<String> bridge, List<String> userDirection) {
        StringBuilder upBridge = new StringBuilder("[ ");

        for (int i = 0; i < bridge.size() && i < userDirection.size(); ++i) {
            upBridge.append(renderUpBridgeEachPoint(i, bridge, userDirection));

            if (userDirection.size() - 1 != i) {
                upBridge.append(" ").append(separator).append(" ");
            }
        }
        return upBridge.append(" ]").toString();
    }

    private String renderDownBridge(List<String> bridge, List<String> userDirection) {
        StringBuilder downBridge = new StringBuilder("[ ");

        for (int i = 0; i < bridge.size() && i < userDirection.size(); ++i) {
            downBridge.append(renderDownBridgeEachPoint(i, bridge, userDirection));

            if (userDirection.size() - 1 != i) {
                downBridge.append(" ").append(separator).append(" ");
            }
        }
        return downBridge.append(" ]").toString();
    }

    private String renderUpBridgeEachPoint(int location, List<String> bridge, List<String> userDirection) {
        if (userDirection.get(location).equals("U")) {
            return renderSuccessStatus(location, bridge, userDirection);
        }

        return " ";
    }

    private String renderDownBridgeEachPoint(int location, List<String> bridge, List<String> userDirection) {
        if (userDirection.get(location).equals("D")) {
            return renderSuccessStatus(location, bridge, userDirection);
        }

        return " ";
    }

    private String renderSuccessStatus(int location, List<String> bridge, List<String> userDirection) {
        String status = "X";

        if (bridge.get(location).equals(userDirection.get(location))) {
            status = "O";
        }

        return status;
    }
}
