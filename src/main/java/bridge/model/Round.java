package bridge.model;

import static bridge.model.RoundStatus.CLEAR;
import static bridge.model.RoundStatus.FAIL;
import static bridge.model.RoundStatus.PLAYING;

import bridge.util.MapAdapter;
import java.util.ArrayList;
import java.util.List;

public class Round {
    private int currentIndex;
    private RoundStatus roundStatus;
    private final List<String> map;

    public Round() {
        currentIndex = 0;
        roundStatus = PLAYING;
        map = new ArrayList<>();
    }

    private boolean isMovable(List<Integer> accessibleIndexes) {
        return accessibleIndexes.contains(currentIndex);
    }

    public void updateStatusAfterMove(String direction, List<Integer> accessibleIndexes) {
        map.add(direction);

        if (isMovable(accessibleIndexes)) {
            currentIndex++;
            return;
        }

        roundStatus = FAIL;
    }

    public List<String> getMap() {
        return MapAdapter.changeMap(map, roundStatus);
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
