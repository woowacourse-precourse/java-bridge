package bridge;

import java.util.StringJoiner;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static StringJoiner upBridge = new StringJoiner("|", "[", "]");
    private static StringJoiner downBridge = new StringJoiner("|", "[", "]");

    public static StringJoiner getUpBridge() {
        return upBridge;
    }

    public static StringJoiner getDownBridge() {
        return downBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving, String answer) {
        if (moving.equals(answer)) {
            mark(moving, "O");
        }
        if (!moving.equals(answer)) {
            mark(moving, "X");
        }
    }

    public void mark(String moving, String result) {
        if (moving.equals("U")) {
            upBridge.add(result);
            downBridge.add(" ");
        }
        if (moving.equals("D")) {
            upBridge.add(" ");
            downBridge.add(result);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
