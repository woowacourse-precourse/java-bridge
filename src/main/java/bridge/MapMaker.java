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
        Map mapWithoutLastColumn = makeMapWithoutLastColumn(steps.getSteps());
        MapColumn lastColumn = makeLastColumnByComparison(bridge, steps);

        Map completeMap = mapWithoutLastColumn.add(lastColumn);

        String up = completeMap.upperRow();
        String down = completeMap.lowerRow();

        return List.of(up, down);
    }

    private static MapColumn makeLastColumnByComparison(Bridge bridge, PlayerSteps steps) {
        String comparisonResult = compareLastStepWithBridge(bridge, steps);
        return convertToColumn(steps, comparisonResult);
    }

    private static MapColumn convertToColumn(PlayerSteps steps, String lastStepResult) {
        if (steps.lastStepEquals(Node.UP)) {
            return new MapColumn(lastStepResult, EMPTY);
        }
        return new MapColumn(EMPTY, lastStepResult);
    }

    private static String compareLastStepWithBridge(Bridge bridge, PlayerSteps steps) {
        if (steps.isLastStepSameWithBridge(bridge)) {
            return CORRECT_NODE;
        }
        return INCORRECT_NODE;
    }

    private static Map makeMapWithoutLastColumn(List<Node> bridgeNodes) {
        Map mapWithOutLastColumn = new Map();

        for (int i = 0; i < bridgeNodes.size() - 1; i++) {
            MapColumn columnOfMap = makeAColumnFromSteps(bridgeNodes, i);
            mapWithOutLastColumn.add(columnOfMap);
        }

        return mapWithOutLastColumn;
    }

    private static MapColumn makeAColumnFromSteps(List<Node> steps, int nodeIdx) {
        String upAppend = EMPTY, downAppend = EMPTY;
        if (steps.get(nodeIdx).equals(Node.UP)) {
            upAppend = CORRECT_NODE;
            return new MapColumn(upAppend, downAppend);
        }
        downAppend = CORRECT_NODE;
        return new MapColumn(upAppend, downAppend);
    }
}

