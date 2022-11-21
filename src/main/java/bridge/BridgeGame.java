package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String moving, List<String> correctBridge, int currentLocation) {
        if (moving.equals(correctBridge.get(currentLocation))) {
            setCorrectBridge(moving);
            return "O";
        }
        setWrongBridge(moving);
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        upBridge.clear();
        downBridge.clear();
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    private void setCorrectBridge(String moving) {
        if (moving.equals("U")) {
            upBridge.add("O");
            downBridge.add(" ");
        } else if (moving.equals("D")) {
            upBridge.add(" ");
            downBridge.add("O");
        }
    }

    private void setWrongBridge(String moving) {
        if (moving.equals("U")) {
            upBridge.add("X");
            downBridge.add(" ");
        } else if (moving.equals("D")) {
            upBridge.add(" ");
            downBridge.add("X");
        }
    }

}
