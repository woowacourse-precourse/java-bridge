package bridge.service;

import bridge.constant.Score;
import bridge.model.Bridge;
import bridge.model.BridgePosition;
import bridge.model.GameResult.Result;
import bridge.model.Move;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgePosition bridgePosition;
    private final Move move;
    private final Result result;

    public BridgeGame () {
        move = new Move();
        result = new Result();
    }

    public void createBridge(List<String> bridgeInput) {
        Bridge bridge = new Bridge(bridgeInput);
        bridgePosition = new BridgePosition(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveDirection) {
        move.setMoveDirection(moveDirection);
        bridgePosition.addCurrentRoundNumber();
    }

    public List<List<String>> judgeResultByMove(String moveDirection) {
        Score score = move.judge(bridgePosition);

        result.updateBridgeRecord(score, moveDirection);
        return result.getBridgeRecord();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result.addTryCount();
        bridgePosition.resetCurrentRoundNumber();
        result.deleteBridgeRecord();
    }

    public Boolean isFail() {
        String moveDirection = move.getMoveDirection();
        Boolean isFail = bridgePosition.isFail(moveDirection);
        if (isFail) {
            bridgePosition.resetCurrentRoundNumber();
        }
        return isFail;
    }

    public Boolean isRoundLeft() {
        return bridgePosition.isRoundLeft();
    }

    public List<List<String>> getBridgeRecord() {
        return result.getBridgeRecord();
    }

    public String getScoreMessage() {
        return move.getScoreMessage();
    }

    public int getTryCount() {
        return result.getTryCount();
    }
}
