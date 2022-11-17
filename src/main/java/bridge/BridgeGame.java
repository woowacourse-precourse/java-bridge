package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    int position = 0;
    int count = 1;

    StringBuilder[] map = {new StringBuilder(),  new StringBuilder()};
    boolean flag = true;
    List<String> bridge;

    BridgeGame(List<String> bridge, int position, boolean flag) {
        this.bridge = bridge;
        this.position = position;
        this.flag = flag;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (bridge.get(position).equals(moving)) {
            setMap(moving, "O");
        }
        if (!bridge.get(position).equals(moving)) {
            setMap(moving, "X");
            flag = false;
        }
        position++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }
}
