package bridge.domain;

import bridge.enums.BridgeStatus;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private static final int UP_INDEX = 0;
    private static final int DOWN_INDEX = 1;
    private static final int LIST_SIZE = 2;

    private List<String>[] result;

    public GameResult() {
        this.result = new ArrayList[LIST_SIZE];
        for (int i = 0; i < LIST_SIZE; i++) {
            result[i] = new ArrayList<>();
        }
    }
    public void add(int index, String answer) {
        result[index].add(answer);
        result[(index + 1) % LIST_SIZE].add(BridgeStatus.EMPTY.getValue());
    }

    public boolean isUnavailable(int lastIndex) {
        if (BridgeStatus.UNAVAILABLE.equals(result[UP_INDEX].get(lastIndex)) ||
                BridgeStatus.UNAVAILABLE.equals(result[DOWN_INDEX].get(lastIndex))) {
            return true;
        }
        return false;
    }
    public void clear() {
        result[UP_INDEX].clear();
        result[DOWN_INDEX].clear();
    }
    public List<String>[] getResult() {
        return result;
    }
}
