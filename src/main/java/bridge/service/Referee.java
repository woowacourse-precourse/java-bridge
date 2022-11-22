package bridge.service;

import java.util.Arrays;
import java.util.List;

public class Referee {
    private static final String MOVE_COMMAND_UP = "U";
    private static final String MOVE_COMMAND_DOWN = "D";
    private static final String COMPARE_PATH_EQUAL = "O";
    private static final String COMPARE_PATH_NOT_EQUAL = "X";
    private static final int BRIDGE_COUNT = 2;
    private static final String RESULT_WIN = "성공";
    private static final String RESULT_FAIL = "실패";

    public static boolean makeResult(List<String> myPaths, List<String> bridgePaths) {
        for (int i = 0; i < bridgePaths.size(); i++) {
            if (!myPaths.get(i).equals(bridgePaths.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static String convertResult(List<String> myPaths, List<String> bridgePaths) {
        if (makeResult(myPaths, bridgePaths)) {
            return RESULT_WIN;
        }
        return RESULT_FAIL;

    }

    private static int convertPath(String path) {
        if (path.equals(MOVE_COMMAND_UP)) {
            return 0;
        }
        return 1;
    }

    private static String comparePath(String movePath, String bridgePath) {
        if (movePath.equals(bridgePath)) {
            return COMPARE_PATH_EQUAL;
        }
        return COMPARE_PATH_NOT_EQUAL;
    }

    public static String[][] makeComparePath(List<String> myPaths, List<String> bridgePaths) {
        String[][] comparePaths = new String[BRIDGE_COUNT][myPaths.size()];

        for (int i = 0; i < BRIDGE_COUNT; i++) {
            Arrays.fill(comparePaths[i], " ");
        }
        for (int j = 0; j < myPaths.size(); j++) {
            String myPath = myPaths.get(j);
            String bridgePath = bridgePaths.get(j);
            comparePaths[convertPath(myPath)][j] = comparePath(myPath, bridgePath);
        }
        return comparePaths;
    }
}
