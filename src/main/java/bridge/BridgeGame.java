package bridge;

import bridge.constant.BridgeGameStstus;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private int step;
    private BridgeGameStstus status;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.step = 0;
        this.status = BridgeGameStstus.PROCEEDING;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동할 방향을 문자열로 받아 이동
     */
    public void move(String dir) {
        BridgeGameStstus nextStatus = calcNextStatus(dir);
        if(nextStatus == BridgeGameStstus.PROCEEDING){
            step++;
            return;
        }
        status = nextStatus;
    }

    private BridgeGameStstus calcNextStatus(String dir){
        if(bridge.get(step).equals(dir)) {
            if(step + 1 >= bridge.size()){
                return BridgeGameStstus.SUCCESS;
            }
            return BridgeGameStstus.PROCEEDING;
        }
        return BridgeGameStstus.FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
