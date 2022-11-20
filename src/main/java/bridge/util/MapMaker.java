package bridge.util;

import java.util.List;

public class MapMaker {
    public static StringBuilder makeMap(List<String> userMoves, List<Boolean> results) {
        StringBuilder topMap = new StringBuilder("[");
        StringBuilder bottomMap = new StringBuilder("[");
        for (int i = 0; i < userMoves.size(); i++) {
            if (!results.get(i)) {
                handleFalseMap(topMap, bottomMap, userMoves.get(i));
                return topMap.append(bottomMap);
            }
            handleTrueMap(topMap, bottomMap, userMoves.get(i));
        }
        handleFinalMap(topMap, bottomMap);
        return topMap.append(bottomMap);
    }

    private static void handleFinalMap(StringBuilder topMap, StringBuilder bottomMap) {
        topMap.deleteCharAt(topMap.lastIndexOf("|"));
        bottomMap.deleteCharAt(bottomMap.lastIndexOf("|"));
        topMap.append("]\n");
        bottomMap.append("]");
    }

    private static void handleFalseMap(StringBuilder topMap, StringBuilder bottomMap, String userMove) {
        if (userMove.equals("U")) {
            topMap.append(" X |");
            bottomMap.append("   |");
            handleFinalMap(topMap, bottomMap);
            return;
        }
        bottomMap.append(" X |");
        topMap.append("   |");
        handleFinalMap(topMap, bottomMap);
    }

    private static void handleTrueMap(StringBuilder topMap, StringBuilder bottomMap, String userMove) {
        if (userMove.equals("U")) {
            topMap.append(" O |");
            bottomMap.append("   |");
            return;
        }
        bottomMap.append(" O |");
        topMap.append("   |");
    }
}
