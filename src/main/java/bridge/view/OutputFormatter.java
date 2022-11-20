package bridge.view;

import static bridge.domain.BridgeGame.DOWN_BRIDGE;
import static bridge.domain.BridgeGame.UP_BRIDGE;

import bridge.domain.MovingMap;
import bridge.domain.MovingMapState;
import java.util.Map;
import java.util.StringJoiner;

public class OutputFormatter {

    public static String formatMovingMap(MovingMap movingMap) {
        String upLine = formatMovingMapLine(movingMap, UP_BRIDGE);
        String downLine = formatMovingMapLine(movingMap, DOWN_BRIDGE);

        return upLine + "\n" + downLine;
    }

    private static String formatMovingMapLine(MovingMap movingMap, String targetMoving) {
        StringJoiner joiner = new StringJoiner(" | ", "[ ", " ]");

        for (int pos = 0; pos < movingMap.getLength(); pos++) {
            String s = formatStateOfMovingMap(movingMap.getState(targetMoving, pos));
            joiner.add(s);
        }

        return joiner.toString();
    }

    private static String formatStateOfMovingMap(MovingMapState state) {
        final Map<MovingMapState, String> stateToString = Map.of(
                MovingMapState.NOT_GOING, " ",
                MovingMapState.SUCCESS, "O",
                MovingMapState.FAIL, "X"
        );

        return stateToString.get(state);
    }
}
