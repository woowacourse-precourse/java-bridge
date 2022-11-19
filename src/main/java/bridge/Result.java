package bridge;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private static final String UP_SIGN = "U";
    private static final String DOWN_SIGN = "D";

    private int tryCount;
    private List<MoveDirection> directions;
    private List<Boolean> isAnswers;

    public Result() {
        directions = new ArrayList<>();
        isAnswers = new ArrayList<>();
    }

    private void increaseTryCount() {
        tryCount++;
    }

    public void updateIsAnswers(MoveDirection direction, boolean isAnswer) {
        directions.add(direction);
        isAnswers.add(isAnswer);
        increaseTryCount();
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<MoveDirection> getDirections() {
        return directions;
    }

    public List<Boolean> getIsAnswers() {
        return isAnswers;
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
}
