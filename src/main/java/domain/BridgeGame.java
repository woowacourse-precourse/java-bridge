package domain;

import bridge.enums.SuccessOrFail;
import bridge.enums.Answer;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    final private List<String> bridge;
    private List<Boolean> userMove;
    private int tryTimes;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        tryTimes = 0;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<Boolean> getUserMove() {
        return userMove;
    }

    public int getTryTimes() {
        return tryTimes;
    }

    public void initUserMove() {
        userMove = new ArrayList<>();
        tryTimes++;
    }

    public void move(String move) {
        validateMove(move);
        addUserMove(moveResult(move));
    }

    private void addUserMove(boolean result) {
        userMove.add(result);
    }

    private boolean moveResult(String move) {
        return bridge.get(userMove.size()).equals(move);
    }

    private void validateMove(String move) {
        if (!move.equals(Answer.Up.getAnswer()) && !move.equals(Answer.Down.getAnswer())) {
            throw new IllegalArgumentException();
        }
    }

    public boolean moreAsk() {
        return bridge.size() == userMove.size();
    }

    public boolean gameResult() {
        return userMove.get(userMove.size() - 1);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        return validateRetry(command);
    }

    private boolean validateRetry(String command) {
        if (command.equals(Answer.Quit.getAnswer())) {
            return SuccessOrFail.getFail();
        } else if (command.equals(Answer.Retry.getAnswer())) {
            return SuccessOrFail.getSuccess();
        }
        throw new IllegalArgumentException();
    }

}
