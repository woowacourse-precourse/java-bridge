package bridge.service;

import bridge.enums.BridgeStatus;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<String>[] result;

    public GameResult() {
        this.result = new ArrayList[2];
        for (int i = 0; i < 2; i++) {
            result[i] = new ArrayList<>();
        }
    }
    public void add(int index, String answer) {
        result[index].add(answer);
        result[(index + 1) % 2].add(BridgeStatus.EMPTY.getValue());
    }

    public boolean isUnavailable(int lastIndex) {
        if (BridgeStatus.UNAVAILABLE.equals(result[0].get(lastIndex)) ||
                BridgeStatus.UNAVAILABLE.equals(result[1].get(lastIndex))) {
            return true;
        }
        return false;
    }
    public void clear() {
        result[0].clear();
        result[1].clear();
    }
    public List<String>[] getResult() {
        return result;
    }
}
