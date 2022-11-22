package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private final Bridge bridge;
    private final List<ResultFlag> upperLine = new ArrayList<>();
    private final List<ResultFlag> lowerLine = new ArrayList<>();

    public BridgeResult(Bridge bridge) {
        this.bridge = bridge;
    }

    private void saveResult(String moveCommand) {
        if (moveCommand.equals("U")) {

        }
        if (moveCommand.equals("D")) {

        }
    }
}
