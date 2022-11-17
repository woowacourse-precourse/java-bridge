package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.GameResult;

public class MovingService {

    public static String crossBridge(Bridge bridge, String moving, int lastPosition) {
        if (bridge.canCross(lastPosition, moving)) {
            return "O";
        }
        return "X";
    }

    private static void recordCrossResult(String crossOrNot) {
    }

}
