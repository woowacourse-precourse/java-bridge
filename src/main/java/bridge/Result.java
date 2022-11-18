package bridge;

import java.util.ArrayList;
import java.util.List;

public class Result {
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


}
