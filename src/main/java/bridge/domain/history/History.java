package bridge.domain.history;

import bridge.domain.position.BridgePosition;
import bridge.domain.position.SurviveStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class History {
    private final List<StagedHistory> history;

    public History() {
        this.history = new ArrayList<StagedHistory>();
    }

    public void record(SurviveStatus surviveStatus, BridgePosition bridgePosition) {
        this.history.add(new StagedHistory(surviveStatus, bridgePosition));
    }

    public String resultByPositions() {
        return Arrays.stream(BridgePosition.values()).map(bridgePosition -> {
            var stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(history.stream()
                    .map(stagedHistory -> stagedHistory.resultSurviveStatusByBridgePosition(bridgePosition))
                    .collect(Collectors.joining("|")));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }).collect(Collectors.joining("\n"));

    }
}
