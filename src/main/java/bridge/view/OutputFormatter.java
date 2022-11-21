package bridge.view;

import static bridge.domain.BridgeGame.*;
import static bridge.domain.MovingMapState.*;

import bridge.domain.MovingMap;
import bridge.domain.MovingMapState;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputFormatter {

    public String formatMovingMap(MovingMap movingMap) {
        String upLine = formatMovingMapLine(movingMap, UP_BRIDGE);
        String downLine = formatMovingMapLine(movingMap, DOWN_BRIDGE);

        return upLine + "\n" + downLine;
    }

    private String formatMovingMapLine(MovingMap movingMap, String targetMoving) {
        return movingMap.getStateList(targetMoving).stream()
                .map(this::formatStateOfMovingMap)
                .collect(Collectors.joining(" | ", "[ ", " ]"));
    }

    private String formatStateOfMovingMap(MovingMapState state) {
        final Map<MovingMapState, String> stateToString = Map.of(
                NOT_GOING, " ",
                SUCCESS, "O",
                FAIL, "X");

        return stateToString.get(state);
    }
}
