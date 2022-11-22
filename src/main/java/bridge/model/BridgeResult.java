package bridge.model;

import java.util.ArrayList;
import java.util.List;

import static bridge.Constant.MOVING_COMMAND_DOWN;
import static bridge.Constant.MOVING_COMMAND_UP;

public class BridgeResult {
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_MIDDLE = " | ";
    private static final String BRIDGE_END = " ]";
    private final Bridge bridge;
    private final List<ResultFlag> upperLine = new ArrayList<>();
    private final List<ResultFlag> lowerLine = new ArrayList<>();
    private int crossingCount = 0;

    public BridgeResult(Bridge bridge) {
        this.bridge = bridge;
    }

    public ResultFlag move(String moveCommand) {
        saveResult(moveCommand);
        ResultFlag resultFlag = isCrossing(moveCommand);
        crossingCount++;
        return resultFlag;
    }

    private void saveResult(String moveCommand) {
        if (moveCommand.equals(MOVING_COMMAND_UP)) {
            upperLine.add(isCrossing(moveCommand));
            lowerLine.add(ResultFlag.NOTHING);
        }
        if (moveCommand.equals(MOVING_COMMAND_DOWN)) {
            upperLine.add(ResultFlag.NOTHING);
            lowerLine.add(isCrossing(moveCommand));
        }
    }

    private ResultFlag isCrossing(String moveCommand) {
        List<String> bridges = bridge.getBridge();
        if (bridges.get(crossingCount).equals(moveCommand)) {
            return ResultFlag.SUCCESS;
        }
        return ResultFlag.FAIL;
    }

    public String getUpperLine() {
        return drawResult(upperLine);
    }

    public String getLowerLine() {
        return drawResult(lowerLine);
    }

    private String drawResult(List<ResultFlag> shape) {
        String bracket = BRIDGE_START;
        for (int index = 0; index < shape.size(); index++) {
            if (index != 0) {
                bracket += BRIDGE_MIDDLE;
            }
            bracket += shape.get(index).getShape();
        }
        bracket += BRIDGE_END;
        return bracket;
    }

    public void reset() {
        upperLine.clear();
        lowerLine.clear();
        crossingCount = 0;
    }

    public int getCrossingCount() {
        return crossingCount;
    }
}
