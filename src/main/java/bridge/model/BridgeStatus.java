package bridge.model;

import bridge.view.BridgeBlock;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BridgeStatus {
    private final Map<BridgeBlock, List<BlockStatus>> bridgeStatus;

    public BridgeStatus() {
        bridgeStatus = new EnumMap<>(BridgeBlock.class);
        for (BridgeBlock bridgeBlock : BridgeBlock.values()) {
            bridgeStatus.put(bridgeBlock, new ArrayList<>());
        }
    }

    public void update(String currBridge, String currPlayer) {
        boolean correct = currBridge.equals(currPlayer);
        for (BridgeBlock bridgeBlock : BridgeBlock.values()) {
            BlockStatus match = BlockStatus.UNSELECT;
            if (bridgeBlock == BridgeBlock.valueOf(currPlayer)) {
                match = BlockStatus.of(correct);
            }
            bridgeStatus.get(bridgeBlock).add(match);
        }
    }

    public void clear() {
        bridgeStatus.clear();
    }

    public int size() {
        return bridgeStatus.get(BridgeBlock.U).size();
    }

    @Override
    public String toString() {
        StringBuilder totalStatus = new StringBuilder();
        for (BridgeBlock bridgeBlock : BridgeBlock.values()) {
            List<String> status = bridgeStatus.get(bridgeBlock).stream()
                    .map(BlockStatus::toString)
                    .collect(Collectors.toList());
            totalStatus.append(status.toString().replaceAll(",", "|")).append('\n');
        }
        return totalStatus.toString();
    }
}
