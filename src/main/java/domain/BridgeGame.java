package domain;

import bridge.enums.SuccessOrFail;
import bridge.enums.Answer;

import java.util.ArrayList;
import java.util.List;

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

    private void validateMove(String move) {
        if (!move.equals(Answer.Up.getAnswer()) && !move.equals(Answer.Down.getAnswer())) {
            throw new IllegalArgumentException();
        }
    }

    private void addUserMove(boolean result) {
        userMove.add(result);
    }

    private boolean moveResult(String move) {
        return bridge.get(userMove.size()).equals(move);
    }

    public boolean moreAsk() {
        return bridge.size() == userMove.size();
    }

    public boolean isSuccess() {
        return userMove.get(userMove.size() - 1);
    }

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
