package bridge;

import bridge.domain.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    Bridge answerBridge;
    BridgePrintMaker bridgePrintMaker;
    Integer position;
    Integer tryCount;
    Result result;

    public BridgeGame() {
        this.bridgePrintMaker = new BridgePrintMaker();
        this.position = 0;
        this.tryCount = 1;
        this.result = Result.CONTINUE;
    }

    public void setAnswerBridge(Bridge bridge) {
        this.answerBridge = bridge;
    }

    public String getBridgePrintMaker() {
        return bridgePrintMaker.getBridgePrint();
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public String getResultMessage() {
        return result.getStatusMessage();
    }

    public boolean isContinue() {
        return result.equals(Result.CONTINUE);
    }

    public boolean isFail() {
        return result.equals(Result.FAIL);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userMove) {
        bridgePrintMaker.addStepBridge(userMove, Direction.convertDirection(answerBridge.get(position)));
        position++;
        checkGame();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.bridgePrintMaker = new BridgePrintMaker();
        position = 0;
        tryCount++;
    }

    private void checkGame() {
        if (position.equals(answerBridge.size())) {
            result = Result.SUCCESS;
        }

        if (!bridgePrintMaker.isContinueGame()) {
            result = Result.FAIL;
        }
    }

    public void updateRestart(String restart) {
        if (restart.equals(Restart.RESTART.getStatus())) {
            result = Result.CONTINUE;
            retry();
        }
    }
}
