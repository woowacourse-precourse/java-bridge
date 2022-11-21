package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(List<String> bridge, List<String> movement) {
        List<String> movingRoute = new ArrayList<>();
        String upBridgeMap = setMovingRoute(bridge, movement, "U");
        String downBridgeMap = setMovingRoute(bridge, movement, "D");
        movingRoute.add(upBridgeMap);
        movingRoute.add(downBridgeMap);
        return movingRoute;
    }

    private String setMovingRoute(List<String> bridge, List<String> movement, String target) {
        String movingRoute = "";
        for (int i = 0; i < movement.size(); i++) {
            String correctRoute = bridge.get(i);
            String userRoute = movement.get(i);
            movingRoute += compare(correctRoute, userRoute, target);
            movingRoute += checkEndPosition(movement, i);
        }
        return movingRoute;
    }

    private String compare(String correctRoute, String userRoute, String target) {
        String compareResult = " ";
        if (correctRoute.equals(userRoute) && userRoute.equals(target)) {
            compareResult = "O";
        }
        if (!correctRoute.equals(userRoute) && userRoute.equals(target)) {
            compareResult = "X";
        }
        return compareResult;
    }

    private String checkEndPosition(List<String> movement, int index) {
        if (index >= 0 && index < movement.size() - 1) {
            return " | ";
        }
        return "";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
