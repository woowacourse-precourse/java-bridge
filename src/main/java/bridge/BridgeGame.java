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
    private int tryCnt;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.step = 0;
        this.status = BridgeGameStstus.PROCEEDING;
        this.tryCnt = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동할 방향을 문자열로 받아 이동
     */
    public BridgeGameStstus move(String dir) {
        BridgeGameStstus nextStatus = calcNextStatus(dir);
        step++;
        if (nextStatus == BridgeGameStstus.PROCEEDING) {
            return nextStatus;
        }
        status = nextStatus;
        return nextStatus;
    }

    private BridgeGameStstus calcNextStatus(String dir) {
        if (bridge.get(step).equals(dir)) {
            if (step + 1 >= bridge.size()) {
                return BridgeGameStstus.SUCCESS;
            }
            return BridgeGameStstus.PROCEEDING;
        }
        return BridgeGameStstus.FAIL;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 게임의 step정보, status정보를 초기화
     */
    public void retry() {
        step = 0;
        status = BridgeGameStstus.PROCEEDING;
        tryCnt++;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public int getStep() {
        return this.step;
    }

    public BridgeGameStstus getStatus() {
        return this.status;
    }

    public int getTryCnt() {
        return this.tryCnt;
    }
}
