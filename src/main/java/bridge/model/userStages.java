package bridge.model;

import bridge.standard.GameForm;

import java.util.*;

public class userStages {
    private static final String SUCCESS = "성공";
    private static final String FAILS = "실패";

    private static List<List<String>> positions;
    private static int numberOfAttempts;
    private static String outcome;

    protected userStages() {
        positions = new ArrayList<>();
        numberOfAttempts = 1;
        outcome = "";
    }

    protected void savePosition(List<String> mapElement) {
        positions.add(mapElement);
        if (positions.get(positions.size() - 1).contains(GameForm.WRONG_CODE)) {
            outcome = FAILS;
        }
    }

    protected void init() {
        numberOfAttempts++;
        positions.clear();
        outcome = "";
    }

    public static boolean isNotReached(int bridgeSize) {
        if (positions.size() == bridgeSize) {
            outcome = SUCCESS;
            return false;
        }
        return true;
    }
    public static boolean isNotCross() {
        if (outcome == FAILS) {
            return true;
        }
        return false;
    }
    public static int nextIndex() {
        return positions.size();
    }
    public static List<List<String>> getPositions() {
        return positions;
    }
    public static int getNumberOfAttempts() {
        return numberOfAttempts;
    }
    public static String getOutcome() {
        return outcome;
    }
}
