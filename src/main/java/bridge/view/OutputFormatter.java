package bridge.view;

import static bridge.domain.BridgeGame.DOWN_BRIDGE;
import static bridge.domain.BridgeGame.UP_BRIDGE;

import java.util.List;
import java.util.StringJoiner;

public class OutputFormatter {

    public static String formatMovingMap(List<String> movingMap) {
        String upLine = formatMovingMapLine(movingMap, UP_BRIDGE);
        String downLine = formatMovingMapLine(movingMap, DOWN_BRIDGE);

        return upLine + "/n" + downLine;
    }

    private static String formatMovingMapLine(List<String> movingMap, String targetMoving) {
        StringJoiner joiner = new StringJoiner(" | ", "[ ", " ]");
        for (String moving : movingMap) {
            if (targetMoving.equals(moving)) {
                joiner.add("O");
                continue;
            }
            joiner.add(" ");
        }

        return joiner.toString();
    }
}
