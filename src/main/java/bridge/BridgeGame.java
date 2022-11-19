package bridge;

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
    public void move(List<String> topBridge, List<String> bottomBridge, String movement) {
        topBridge.add(bridgeTopExist(movement));
        bottomBridge.add(bridgeBottomExist(movement));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String input) {

        return input.equals("R");
    }

    public void failure(List<String> topBridge, List<String> bottomBridge, String movement) {
        topBridge.add(failureInTop(movement));
        bottomBridge.add(failureInBottom(movement));
    }

    public boolean rightMove(String input, String bridge) {

        return input.equals(bridge);
    }

    private String bridgeTopExist(String movement) {
        if (movement.equals("U")) {
            return "O";
        }
        return " ";
    }

    private String bridgeBottomExist(String movement) {
        if (movement.equals("D")) {
            return "O";
        }
        return " ";
    }

    private String failureInTop(String movement) {
        if (movement.equals("U")) {
            return "X";
        }
        return " ";
    }

    private String failureInBottom(String movement) {
        if (movement.equals("D")) {
            return "X";
        }
        return " ";
    }
}
