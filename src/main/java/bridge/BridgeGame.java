package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<String> userMove = new ArrayList<>();
    private int tryNumber = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     * @param moving 사용자가 이동할 칸. 위 칸이면 "U", 아래 칸이면 "D"로 표현한다.
     * @return 이동의 성공 여부. 성공한 경우 true, 실패한 경우 false를 반환한다.
     */
    public boolean move(String moving) {
        String nextStep = bridge.get(userMove.size());
        userMove.add(moving);
        return moving.equals(nextStep);
    }

    /**
     * 게임이 클리어 되었는지 확인하는 메서드
     *
     * @return 게임의 성공 여부. 성공한 경우 true, 실패한 경우 false를 반환한다.
     */
    public boolean isClear() {
        if (bridge.size() != userMove.size()) {
            return false;
        }
        for (int i = 0; i < bridge.size(); i++) {
            if (!bridge.get(i).equals(userMove.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userMove.clear();
        tryNumber++;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getUserMove() {
        return userMove;
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
