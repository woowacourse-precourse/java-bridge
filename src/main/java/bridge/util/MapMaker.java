package bridge.util;

import java.util.List;

public class MapMaker {
    private static final String MAP_INITIAL = "[";
    private static final String BAR = "|";
    private static final String MAP_FINAL = "]";
    private static final String UP = "U";
    private static final String FAILED_MOVING = " X |";
    private static final String NO_MOVING = "   |";
    private static final String SUCCESSFUL_MOVING = " O |";

    public static StringBuilder makeMap(List<String> userMoves, List<Boolean> results) {
        StringBuilder topMap = new StringBuilder(MAP_INITIAL);
        StringBuilder bottomMap = new StringBuilder(MAP_INITIAL);
        for (int i = 0; i < userMoves.size(); i++) {
            if (!results.get(i)) {
                handleFailedMap(topMap, bottomMap, userMoves.get(i));
                return topMap.append(bottomMap);
            }
            handleSuccessMap(topMap, bottomMap, userMoves.get(i));
        }
        handleFinalMap(topMap, bottomMap);
        return topMap.append(bottomMap);
    }

    private static void handleFinalMap(StringBuilder topMap, StringBuilder bottomMap) {
        topMap.deleteCharAt(topMap.lastIndexOf(BAR));
        bottomMap.deleteCharAt(bottomMap.lastIndexOf(BAR));
        topMap.append(MAP_FINAL + "\n");
        bottomMap.append(MAP_FINAL);
    }

    private static void handleFailedMap(StringBuilder topMap, StringBuilder bottomMap, String userMove) {
        if (userMove.equals(UP)) {
            topMap.append(FAILED_MOVING);
            bottomMap.append(NO_MOVING);
            handleFinalMap(topMap, bottomMap);
            return;
        }
        bottomMap.append(FAILED_MOVING);
        topMap.append(NO_MOVING);
        handleFinalMap(topMap, bottomMap);
    }

    private static void handleSuccessMap(StringBuilder topMap, StringBuilder bottomMap, String userMove) {
        if (userMove.equals(UP)) {
            topMap.append(SUCCESSFUL_MOVING);
            bottomMap.append(NO_MOVING);
            return;
        }
        bottomMap.append(SUCCESSFUL_MOVING);
        topMap.append(NO_MOVING);
    }
}
