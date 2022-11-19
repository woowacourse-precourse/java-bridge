package bridge.vo;

import java.util.ArrayList;
import java.util.List;

import bridge.constant.Direction;
import bridge.dto.TrialResult;

public class GameResults {

    private static final int SIZE_AND_INDEX_DIFFERENCE = 1;

    private final List<TrialResult> trialResults;

    public GameResults() {
        this.trialResults = new ArrayList<>();
    }

    public void add(Direction direction, boolean wasSuccessful) {
        trialResults.add(new TrialResult(direction, wasSuccessful));
    }

    public boolean wasLastSuccessful() {
        TrialResult trialResult = trialResults.get(lastIndex());
        return trialResult.wasSuccessful();
    }

    private int lastIndex() {
        return trialResults.size() - SIZE_AND_INDEX_DIFFERENCE;
    }
}
