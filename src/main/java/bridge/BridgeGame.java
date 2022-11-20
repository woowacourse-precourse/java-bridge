package bridge;

import java.util.List;

import static bridge.BridgeProgram.runBridgeGame;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void move(List<String> moved, String moving) {
        moved.add(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void retry(List<String> bridge, int tryCount) {
        runBridgeGame(bridge, tryCount+1);
    }

    // 다리를 전부 건넜는지 확인하는 기능
    public static boolean isArrivedDestination(List<String> bridge, List<String> moved) {
        int idx = moved.size() - 1;
        return (bridge.size() == moved.size()) && (moved.get(idx).equals(bridge.get(idx)));
    }

    // 다리를 건너다 실패했는지 확인하는 기능
    public static boolean isFailed(List<String> bridge, List<String> moved) {
        int idx = moved.size() - 1;
        return !moved.get(idx).equals(bridge.get(idx));
    }

}
