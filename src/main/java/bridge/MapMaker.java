package bridge;

import bridge.model.PlayerSteps;
import bridge.model.bridge.Bridge;
import bridge.model.bridge.Node;
import bridge.model.map.Column;
import bridge.model.map.Columns;
import java.util.List;

public class MapMaker {
    private static final String CORRECT_NODE = "O";
    private static final String INCORRECT_NODE = "X";
    private static final String EMPTY = " ";

    public static List<String> make(Bridge bridge, PlayerSteps steps) {
        Columns columnsWithoutLastColumn = makeMapWithoutLastColumn(steps);
        Column lastColumn = makeLastColumnByComparison(bridge, steps);

        Columns completeColumns = columnsWithoutLastColumn.add(lastColumn);

        String up = completeColumns.upperRow();
        String down = completeColumns.lowerRow();

        return List.of(up, down);
    }

    private static Column makeLastColumnByComparison(Bridge bridge, PlayerSteps steps) {
        String comparisonResult = compareLastStepWithBridge(steps, bridge);
        return convertToColumn(steps, comparisonResult);
    }

    private static Column convertToColumn(PlayerSteps steps, String lastStepResult) {
        if (steps.lastStepEquals(Node.UP)) {
            return new Column(lastStepResult, EMPTY);
        }
        return new Column(EMPTY, lastStepResult);
    }

    private static String compareLastStepWithBridge(PlayerSteps steps, Bridge bridge) {
        if (steps.isLastStepSameWithBridge(bridge)) {
            return CORRECT_NODE;
        }
        return INCORRECT_NODE;
    }

    private static Columns makeMapWithoutLastColumn(PlayerSteps steps) {
        Columns columnsWithOutLastColumn = new Columns();

        for (int i = 0; i < steps.size() - 1; i++) {
            Column columnOfMap = makeAColumnFromSteps(steps, i);
            columnsWithOutLastColumn.add(columnOfMap);
        }

        return columnsWithOutLastColumn;
    }

    private static Column makeAColumnFromSteps(PlayerSteps steps, int nodeIdx) {
        String upAppend = EMPTY, downAppend = EMPTY;
        if (steps.isUpperStepFor(nodeIdx)) {
            upAppend = CORRECT_NODE;
            return new Column(upAppend, downAppend);
        }
        downAppend = CORRECT_NODE;
        return new Column(upAppend, downAppend);
    }
}

