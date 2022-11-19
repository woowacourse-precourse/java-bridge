package bridge;

import bridge.model.PlayerSteps;
import bridge.model.bridge.Bridge;
import bridge.model.bridge.Node;
import bridge.model.map.Map;
import bridge.model.map.MapColumn;
import java.util.List;

public class MapMaker {
    private static final String CORRECT_NODE = "O";
    private static final String INCORRECT_NODE = "X";
    private static final String EMPTY = " ";

    public static List<String> make(Bridge bridge, PlayerSteps steps) {
        Map mapWithoutLast = makeMapWithoutLastColumn(steps.getSteps());
        MapColumn lastColumn = compareAndReturnLastColumn(bridge, steps);
        Map completeMap = mapWithoutLast.add(lastColumn);
        String up = completeMap.upperRow();
        String down = completeMap.lowerRow();
        return List.of(up, down);
    }

    private static MapColumn compareAndReturnLastColumn(Bridge bridge, PlayerSteps steps) {
        String result = compareLastStepResult(bridge, steps);
        return convertToColumn(steps, result);
    }

    private static MapColumn convertToColumn(PlayerSteps steps, String result) {
        String upWithoutLast = EMPTY;
        String downWithoutLast = EMPTY;
        if (lastPlayerStepIsUp(steps)) {
            upWithoutLast = result;
            return new MapColumn(upWithoutLast, downWithoutLast);
        }
        downWithoutLast = result;
        return new MapColumn(upWithoutLast, downWithoutLast);
    }

    private static boolean lastPlayerStepIsUp(PlayerSteps steps) {
        return steps.getLastStep().equals(Node.UP);
    }

    private static String compareLastStepResult(Bridge bridge, PlayerSteps steps) {
        String result = INCORRECT_NODE;
        if (steps.isLastStepSameWithBridge(bridge)) {
            result = CORRECT_NODE;
        }
        return result;
    }

    private static Map makeMapWithoutLastColumn(List<Node> bridgeNodes) {
        Map mapWithOutLastColumn = new Map();

        for (int i = 0; i < bridgeNodes.size() - 1; i++) {
            MapColumn columnOfMap = drawAColumnFromSteps(bridgeNodes, i);
            mapWithOutLastColumn.add(columnOfMap);
        }

        return mapWithOutLastColumn;
    }

    private static MapColumn drawAColumnFromSteps(List<Node> steps, int nodeIdx) {
        String upAppend = EMPTY, downAppend = EMPTY;
        if (steps.get(nodeIdx).equals(Node.UP)) {
            upAppend = CORRECT_NODE;
            return new MapColumn(upAppend, downAppend);
        }
        downAppend = CORRECT_NODE;
        return new MapColumn(upAppend, downAppend);
    }
}

