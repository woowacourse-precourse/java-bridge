package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int tryCount = 1;
    private int bridgeIdx = 0;
    private boolean moveResult;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List bridge, String UorD) {
        if (bridge.get(getBridgeIdx()).equals(UorD)) {
            setMoveResult(true);
            return isMoveResult();
        }
        setMoveResult(false);
        return isMoveResult();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String answer) {
        if (answer.equals("R")) {
            setTryCount(getTryCount() + 1);
            return true;
        }
        return false;
    }

    public String successOrFail(boolean flag) {
        if (flag) {
            return "성공";
        }
        return "실패";
    }

    public void nextStep() {
        if (isMoveResult()) {
            this.bridgeIdx++;
        }
    }

    public boolean reachTheGoal(List bridge, boolean success) {
        if (this.bridgeIdx == bridge.size()) {
            success = true;
        }
        return success;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isMoveResult() {
        return moveResult;
    }

    public void setMoveResult(boolean moveResult) {
        this.moveResult = moveResult;
    }

    public int getBridgeIdx() {
        return bridgeIdx;
    }

    public void setBridgeIdx(int bridgeIdx) {
        this.bridgeIdx = bridgeIdx;
    }
}
