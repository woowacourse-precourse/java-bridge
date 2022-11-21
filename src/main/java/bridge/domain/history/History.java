package bridge.domain.history;

import bridge.domain.code.BridgePosition;
import bridge.domain.code.SurviveStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class History {
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String SURVIVE_STATUS_DELIMITER = "|";
    private static final String NEW_LINE = "\n";
    private final List<StagedHistory> history;

    public History() {
        this.history = new ArrayList<>();
    }

    public void record(SurviveStatus surviveStatus, BridgePosition bridgePosition) {
        this.history.add(new StagedHistory(surviveStatus, bridgePosition));
    }

    public String resultByPositions() {
        return Arrays.stream(BridgePosition.values())
                .map(bridgePosition -> {
                    var stringBuilder = new StringBuilder();
                    stringBuilder.append(OPEN_BRACKET);
                    stringBuilder.append(this.resultByPosition(bridgePosition));
                    stringBuilder.append(CLOSE_BRACKET);
                    return stringBuilder.toString();
                }).collect(Collectors.joining(NEW_LINE));
    }

    private String resultByPosition(BridgePosition bridgePosition) {
        return history.stream()
                .map(stagedHistory -> stagedHistory.resultSurviveStatusByBridgePosition(bridgePosition))
                .collect(Collectors.joining(SURVIVE_STATUS_DELIMITER));
    }
}
