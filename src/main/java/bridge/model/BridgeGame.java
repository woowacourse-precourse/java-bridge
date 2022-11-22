package bridge.model;

import bridge.constant.Score;
import bridge.model.GameResult.Result;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Referee referee;
    private Bridge bridge;
    private User user = new User();
    private Result result = new Result();

    public void createBridge(List<String> bridgeInput) {
        bridge = new Bridge(bridgeInput);
        referee = new Referee(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveDirection) {
        user.setMoveDirection(moveDirection);
    }

    public void judgeMove(String moveDirection) {
        referee.addCurrentRoundNumber();
        Score score = referee.judgeMove(moveDirection);

        user.setScore(score);
        result.updateBridgeRecord(score, moveDirection);
    }

    public List<List<String>> getRecordByMove(String moveDirection) {
        move(moveDirection);
        judgeMove(moveDirection);
        return result.getBridgeRecord();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        result.addTryCount();
        referee.resetCurrentRoundNumber();
        result.deleteBridgeRecord();
    }

    public Boolean isFail() {
        String moveDirection = user.getMoveDirection();
        Boolean isFail = referee.isFail(moveDirection);
        if (isFail) {
            referee.resetCurrentRoundNumber();
        }
        return isFail;
    }

    public Boolean isRoundLeft() {
        int currentRoundNumber = referee.getCurrentRoundNumber();
        return bridge.isRoundLeft(currentRoundNumber);
    }

    public Boolean isGameRestart(String userChoice) {
        return referee.isGameRestart(userChoice);
    }

    public List<List<String>> getBridgeRecord() {
        return result.getBridgeRecord();
    }

    public String getScoreMessage() {
        return user.getScoreMessage();
    }

    public int getTryCount() {
        return result.getTryCount();
    }
}
