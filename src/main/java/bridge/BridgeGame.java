package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static BridgeGame instance;

    private BridgeGame() {
    }

    public static BridgeGame getInstance() {
        if (instance == null) {
            instance = new BridgeGame();
        }
        return instance;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public int move(String userInput, List<String> bridge, int cnt) {
        if(userInput.equals("U")) {
            if(moveUp(bridge, cnt)) {
                cnt++;
            }
        }

        if(userInput.equals("D")) {

        }
        return cnt;
    }

    private boolean moveUp(List<String> bridge, int cnt) {
        String upOrDown = bridge.get(cnt);
        return upOrDown.equals("U");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
