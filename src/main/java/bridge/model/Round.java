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

    public boolean isMovable(List<Integer> accessibleIndexes) {
        return accessibleIndexes.contains(currentIndex);
    }

    public void updateStatusWhenMovable(String direction) {
        map.add(direction);
        currentIndex++;
    }

    public void updateStatusWhenImmovable(String direction) {
        map.add(direction);
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
