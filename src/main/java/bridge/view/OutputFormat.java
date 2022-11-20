package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.BridgeGameResult;
import bridge.domain.BridgeShape;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputFormat {
    private static final String MOVE_SUCCESS = " O ";
    private static final String MOVE_FAIL = " X ";
    private static final String MOVE_NOT_SELECT = "   ";
    private static final String BRIDGE_DELIMITER = "|";
    private static final String BRIDGE_END = "]";
    private static final String BRIDGE_START = "[";
    private static final String NEW_LINE = "\n";

    public String bridgeGameResultFormat(BridgeGameResult result) {
        Bridge bridge = result.bridge();
        List<BridgeShape> bridgeShapes = bridge.bridgeShapes();
        List<Boolean> booleans = result.attemptsResult();
        return String.join(NEW_LINE, upSideFormat(bridgeShapes, booleans), downSideFormat(bridgeShapes, booleans));
    }

    private String upSideFormat(List<BridgeShape> bridgeShapes, List<Boolean> booleans) {
        List<String> upSidesTexts = IntStream.range(0, booleans.size())
                .mapToObj(index -> moveUpSideFormat(booleans.get(index), bridgeShapes.get(index)))
                .collect(Collectors.toList());
        return bridgeSideFormat(upSidesTexts);
    }

    private String moveUpSideFormat(boolean move, BridgeShape bridgeShape) {
        if (move && bridgeShape == BridgeShape.UP) {
            return MOVE_SUCCESS;
        }
        if (!move && bridgeShape == BridgeShape.DOWN) {
            return MOVE_FAIL;
        }
        return MOVE_NOT_SELECT;
    }

    private String downSideFormat(List<BridgeShape> bridgeShapes, List<Boolean> booleans) {
        List<String> downSideTexts = IntStream.range(0, booleans.size())
                .mapToObj(index -> moveDownSideFormat(booleans.get(index), bridgeShapes.get(index)))
                .collect(Collectors.toList());
        return bridgeSideFormat(downSideTexts);
    }

    private String moveDownSideFormat(boolean move, BridgeShape bridgeShape) {
        if (move && bridgeShape == BridgeShape.DOWN) {
            return MOVE_SUCCESS;
        }
        if (!move && bridgeShape == BridgeShape.UP) {
            return MOVE_FAIL;
        }
        return MOVE_NOT_SELECT;
    }

    private String bridgeSideFormat(List<String> moveSideTexts) {
        return BRIDGE_START + String.join(BRIDGE_DELIMITER, moveSideTexts) + BRIDGE_END;
    }
}
