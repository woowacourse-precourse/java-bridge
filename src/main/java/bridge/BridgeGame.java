package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final List<String> up_bridge = new ArrayList<>();
    private static final List<String> down_bridge = new ArrayList<>();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge, String updown, int count) {
        if(updown.contains(bridge.get(count))){
            if (updown.contains("U")) {
                up_bridge.add("O");
                down_bridge.add(" ");
            } else {
                down_bridge.add("O");
                up_bridge.add(" ");
            }
            return true;
        }
        else{
            if (updown.contains("U")) {
                up_bridge.add("X");
                down_bridge.add(" ");
            } else {
                down_bridge.add("X");
                up_bridge.add(" ");
            }
            return false;
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
