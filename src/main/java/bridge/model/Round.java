package bridge.model;

import static bridge.model.RoundStatus.CLEAR;
import static bridge.model.RoundStatus.FAIL;
import static bridge.model.RoundStatus.PLAYING;

import bridge.util.PathResultAdapter;
import java.util.ArrayList;
import java.util.List;

public class Round {
    private int currentIndex;
    private RoundStatus roundStatus;
    private final List<String> course;

    public Round() {
        currentIndex = 0;
        roundStatus = PLAYING;
        course = new ArrayList<>();
    }

    private boolean isMovable(List<Integer> accessibleIndexes) {
        return accessibleIndexes.contains(currentIndex);
    }

    public void updateStatusAfterMove(String direction, List<Integer> accessibleIndexes) {
        course.add(direction);

        if (isMovable(accessibleIndexes)) {
            currentIndex++;
            return;
        }

        roundStatus = FAIL;
    }

    public List<String> getCourseResult() {
        return PathResultAdapter.changePathResult(course, roundStatus);
    }

    private void checkRoundStatus(int destinationIndex) {
        if (!roundStatus.equals(FAIL) && currentIndex > destinationIndex) {
            roundStatus = CLEAR;
        }
    }

    public boolean isRoundPlaying(int destinationIndex) {
        checkRoundStatus(destinationIndex);
        return roundStatus == PLAYING;
    }

    public boolean isClear() {
        return roundStatus == CLEAR;
    }
}
