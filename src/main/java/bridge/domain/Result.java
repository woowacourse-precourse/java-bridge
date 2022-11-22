package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
    private static final String UP_SIGN = "U";
    private static final String DOWN_SIGN = "D";
    private final List<MoveDirection> directions;
    private final List<Boolean> isAnswers;
    private int tryCount;

    public Result() {
        directions = new ArrayList<>();
        isAnswers = new ArrayList<>();
    }

    public void increaseTryCount() {
        tryCount++;
    }

    public void updateIsAnswers(MoveDirection direction, boolean isAnswer) {
        directions.add(direction);
        isAnswers.add(isAnswer);
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<MoveDirection> getDirections() {
        return Collections.unmodifiableList(directions);
    }

    public List<Boolean> getIsAnswers() {
        return Collections.unmodifiableList(isAnswers);
    }

    public boolean isUpSignAnswer(boolean isAnswer, MoveDirection direction) {
        return isAnswer && direction.isEqualTo(UP_SIGN);
    }

    public boolean isUpSignWrongAnswer(boolean isAnswer, MoveDirection direction) {
        return !isAnswer && direction.isEqualTo(UP_SIGN);
    }

    public boolean isDownSignAnswer(boolean isAnswer, MoveDirection direction) {
        return isAnswer && direction.isEqualTo(DOWN_SIGN);
    }

    public boolean isDownSignWrongAnswer(boolean isAnswer, MoveDirection direction) {
        return !isAnswer && direction.isEqualTo(DOWN_SIGN);
    }

    public boolean hasWrong() {
        return isAnswers.contains(false);
    }

    public void initResult() {
        directions.clear();
        isAnswers.clear();
    }
}
