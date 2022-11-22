package bridge.model;

import bridge.constant.BridgePattern;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Progress {

    private final Map<BridgePattern, List<String>> progress;

    private final String EMPTY_VALUE = " ";

    public Progress(int length) {
        this.progress = initProgress(length);
    }

    private Map<BridgePattern, List<String>> initProgress(int length) {
        return new EnumMap<>(BridgePattern.class) {{
            for (BridgePattern bridgePattern : BridgePattern.values()) {
                put(bridgePattern, new ArrayList<>(length));
            }
        }};
    }

    public void updateProgress(BridgePattern inputPattern, String symbol) {
        progress.forEach((bridgePattern, progress) -> {
            String state = inspectSymbol(inputPattern, bridgePattern, symbol);
            progress.add(state);
        });
    }

    public void clearProgress() {
        for (List<String> stage : progress.values()) {
            stage.clear();
        }
    }

    public String inspectSymbol(BridgePattern inputPattern, BridgePattern bridgePattern, String symbol) {
        if (inputPattern == bridgePattern) {
            return symbol;
        }

        return EMPTY_VALUE;
    }

    public Map<BridgePattern, List<String>> getProgress() { return progress; }
}
