package bridge.service;

import java.util.Arrays;
import java.util.List;

public class Referee {
    private static final String MOVE_COMMAND_UP = "U";
    private static final String MOVE_COMMAND_DOWN = "D";
    private static final String COMPARE_PATH_EQUAL = "O";
    private static final String COMPARE_PATH_NOT_EQUAL = "X";
    private static final int BRIDGE_COUNT = 2;

    public int convertPath(String path) {
        if (path.equals(MOVE_COMMAND_UP)) {
            return 1;
        }
        return 0;
    }

    public String comparePath(String movePath, String bridgePath) {
        if (movePath.equals(bridgePath)) {
            return COMPARE_PATH_EQUAL;
        }
        return COMPARE_PATH_NOT_EQUAL;
    }

    public String[][] makeComparePath(List<String> myPaths, List<String> bridgePaths) {
        String[][] comparePaths = new String[BRIDGE_COUNT][];

        for (int i = 0; i < BRIDGE_COUNT; i++) {
            Arrays.fill(comparePaths[i], " ");
            for (int j = 0; j < myPaths.size(); i++) {
                String myPath = myPaths.get(i);
                String bridgePath = bridgePaths.get(i);
                comparePaths[i][convertPath(myPath)] = comparePath(myPath, bridgePath);
            }
        }
        return comparePaths;
    }
}
