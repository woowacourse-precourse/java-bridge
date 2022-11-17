package bridge.model;

import java.util.*;

public class userStage {
    private static final String SUCCESS = "성공";
    private static final String FAILS = "실패";

    private static List<List<String>> positions;
    private static int numberOfAttempts;
    private static String outcome;

    protected userStage() {
        positions = new ArrayList<>();
        numberOfAttempts = 1;
        outcome = "";
    }

    protected void savePosition(String mapElement) {
        positions.add(Arrays.asList(mapElement.split("-")));
        if (positions.get(getSize() - 1).contains("X")) {
            outcome = FAILS;
        }
    }

    protected void init() {
        numberOfAttempts++;
        positions.clear();
        outcome = "";
    }

    protected void updateSuccess() {
        outcome = SUCCESS;
    }


    public static boolean isNotCross() {
        if (outcome == FAILS) {
            return true;
        }
        return false;
    }

    public static int getSize() {
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
