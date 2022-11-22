package bridge.bridgeGame;

import bridge.bridgeRouter.BridgeRouter;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameLog {
    private static final int BRIDGE_SIZE = 2;
    private static final String BRIDGE_DEFAULT_VALUE = " ";
    private static final String BRIDGE_CLEAR_VALUE = "O";
    private static final String BRIDGE_FAIL_VALUE = "X";
    private long count;
    private int currentLocation;

    private List<List<String>> bridges;

    public BridgeGameLog() {
        bridges = new ArrayList<>();
        for (int i = 0; i < BRIDGE_SIZE; i++) {
            bridges.add(new ArrayList<>());
        }
        addDefaultValueIfFull();
        count = 1;
    }

    public List<List<String>> getBridges() {
        return bridges;
    }

    public long getCount() {
        return count;
    }

    private void addDefaultValueIfFull() {
        for (int i = 0; i < BRIDGE_SIZE; i++) {
            if (bridges.get(i).size() == currentLocation) {
                bridges.get(i).add(BRIDGE_DEFAULT_VALUE);
            }
        }
    }

    public void addLog(boolean isMove, String command) {
        addDefaultValueIfFull();
        final int bridgeIndex = BridgeRouter.getMatchBridge(command).getIndex();
        bridges.get(bridgeIndex).set(currentLocation, getValue(isMove));
        if (isMove) {
            currentLocation++;
        }
        if (!isMove) {
            count++;
        }
    }

    private String getValue(boolean isEnd) {
        if (isEnd) {
            return BRIDGE_CLEAR_VALUE;
        }
        return BRIDGE_FAIL_VALUE;
    }
}
