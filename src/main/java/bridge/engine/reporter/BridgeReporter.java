package bridge.engine.reporter;

import java.util.List;

public class BridgeReporter {

    /**
     * @param bridge 다리
     * @param userDirection 유저가 이동한 칸
     * @return [ O | X | O ] 형태로 전체 다리를 표현하는 문자열
     * */
    public String reportBridge(List<String> bridge, List<String> userDirection) {
        return renderUpBridge(bridge, userDirection) + "\n" + renderDownBridge(bridge, userDirection);
    }

    /**
     * @param bridge 다리
     * @param userDirection 유저가 이동한 칸
     * @return 위,아래 칸 중에서 위 칸 다리를 표현하는 문자열 [ O | X | O ]
     * */
    private String renderUpBridge(List<String> bridge, List<String> userDirection) {
        StringBuilder upBridge = new StringBuilder("[ ");

        for (int i = 0; i < bridge.size() && i < userDirection.size(); ++i) {
            upBridge.append(renderUpBridgeEachPoint(i, bridge, userDirection));

            if (userDirection.size() - 1 != i) {
                upBridge.append(" ").append("|").append(" ");
            }
        }
        return upBridge.append(" ]").toString();
    }

    /**
     * @param bridge 다리
     * @param userDirection 유저가 이동한 칸
     * @return 위,아래 칸 중에서 아래 칸 다리를 표현하는 문자열 [ X | O | X ]
     * */
    private String renderDownBridge(List<String> bridge, List<String> userDirection) {
        StringBuilder downBridge = new StringBuilder("[ ");

        for (int i = 0; i < bridge.size() && i < userDirection.size(); ++i) {
            downBridge.append(renderDownBridgeEachPoint(i, bridge, userDirection));

            if (userDirection.size() - 1 != i) {
                downBridge.append(" ").append("|").append(" ");
            }
        }
        return downBridge.append(" ]").toString();
    }

    /**
     * @param location 현재 이동한 칸
     * @param bridge 다리
     * @param userDirection 유저가 이동한 칸
     * @return 문자열 "O", "X" 혹은 빈 문자열 " "
     * */
    private String renderUpBridgeEachPoint(int location, List<String> bridge, List<String> userDirection) {
        if (userDirection.get(location).equals("U")) {
            return renderSuccessStatus(location, bridge, userDirection);
        }

        return " ";
    }

    /**
     * @param location 현재 이동한 칸
     * @param bridge 다리
     * @param userDirection 유저가 이동한 칸
     * @return 문자열 "O", "X" 혹은 빈 문자열 " "
     * */
    private String renderDownBridgeEachPoint(int location, List<String> bridge, List<String> userDirection) {
        if (userDirection.get(location).equals("D")) {
            return renderSuccessStatus(location, bridge, userDirection);
        }

        return " ";
    }

    /**
     * @param location 현재 이동한 칸
     * @param bridge 다리
     * @param userDirection 유저가 이동한 칸
     * @return 문자열 "O", "X"
     * */
    private String renderSuccessStatus(int location, List<String> bridge, List<String> userDirection) {
        String status = "X";

        if (bridge.get(location).equals(userDirection.get(location))) {
            status = "O";
        }

        return status;
    }
}
