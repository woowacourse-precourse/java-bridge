package bridge.domain;

import bridge.command.MarkCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private final List<String> result;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        result = new ArrayList<>();
    }

    public void move(String square) {
        if (bridge.get(result.size()).equals(square)) {
            result.add(MarkCommand.Possible.get());
            return;
        }

        result.add(MarkCommand.Impossible.get());
    }

    public void retry() {
        result.clear();
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public int getResultSize() {
        return result.size();
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(result);
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }
}
