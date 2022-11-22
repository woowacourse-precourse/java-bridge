package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private final Bridge bridge;
    private final List<ResultFlag> upperLine = new ArrayList<>();
    private final List<ResultFlag> lowerLine = new ArrayList<>();
    private int crossingCount = 0;

    public BridgeResult(Bridge bridge) {
        this.bridge = bridge;
    }

    private void saveResult(String moveCommand) {
        if (moveCommand.equals("U")) {
            upperLine.add(isCrossing(moveCommand));
            lowerLine.add(ResultFlag.NOTHING);
        }
        if (moveCommand.equals("D")) {
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
}
