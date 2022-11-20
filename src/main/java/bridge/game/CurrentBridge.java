package bridge.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentBridge {
    private final List<BridgeMoveResult> bridgeUpper = new ArrayList<>();
    private final List<BridgeMoveResult> bridgeLower = new ArrayList<>();

    public int size() {
        if (bridgeUpper.size() == bridgeLower.size()) {
            return bridgeUpper.size();
        }
        throw new IllegalStateException("[ERROR]");
    }

    public void update(BridgeMoveResult upperResult, BridgeMoveResult lowerResult) {
        bridgeUpper.add(upperResult);
        bridgeLower.add(lowerResult);
    }

    public List<String> getUpper() {
        return bridgeUpper.stream()
                .map(BridgeMoveResult::text)
                .collect(Collectors.toList());
    }

    public List<String> getLower() {
        return bridgeLower.stream()
                .map(BridgeMoveResult::text)
                .collect(Collectors.toList());
    }

    public void clear() {
        bridgeUpper.clear();
        bridgeLower.clear();
    }

}
