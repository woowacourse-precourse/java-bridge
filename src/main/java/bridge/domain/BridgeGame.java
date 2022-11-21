package bridge.domain;

import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private boolean canMove;
    private boolean doRetry;


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String b, int idx, List<String> bridge) {

        canMove = checkOneStep(b, bridge, idx);
    }

    private boolean checkOneStep(String whereBridge, List<String> bridge, int idx) {
        if (Objects.equals(whereBridge, "U")) {
            return check(bridge, idx);
        }
        return !(check(bridge, idx));
    }

    private boolean check(List<String> bridge, int idx) {
        return Objects.equals(bridge.get(idx), "U");
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String r) {
        doRetry = Objects.equals(r, "R");
    }

    public void initialize(){
        canMove = true;
    }

    public boolean getCanMove() {
        return canMove;
    }

    public boolean getDoRetry() {
        return doRetry;
    }
}
