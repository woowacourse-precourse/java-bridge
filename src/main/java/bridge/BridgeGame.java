package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<String> movingUser = new ArrayList<>();
    private int round = 1;

    public BridgeGame(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move) {
        movingUser.add(move);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        movingUser.clear();
        round++;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<String> getMovingUser() {
        return movingUser;
    }

    public int getRound() {
        return round;
    }

    /**
     * 사용자가 게임에 성공했는지 여부를 판단하는 메서드
     */
    public boolean isSuccess() {
        return bridge.equals(movingUser);
    }

    /**
     * 사용자가 올바르게 이동했는지 판단하는 메서드
     */
    public boolean isRightMove() {
        for (int i = 0; i < movingUser.size(); i++) {
            if (!movingUser.get(i).equals(bridge.get(i))) {
                return false;
            }
        }
        return true;
    }
}
