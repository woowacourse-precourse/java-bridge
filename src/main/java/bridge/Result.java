package bridge;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private int tryCount;
    private List<Boolean> isAnswers;

    public Result() {
        isAnswers = new ArrayList<>();
    }

    private void increaseTryCount() {
        tryCount++;
    }

    public void updateIsAnswers(boolean isAnswer) {
        isAnswers.add(isAnswer);
        increaseTryCount();
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<Boolean> getIsAnswers() {
        return isAnswers;
    }
}
