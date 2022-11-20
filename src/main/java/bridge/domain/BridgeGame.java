package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.BridgeMaker.*;

public class BridgeGame {
    public static final String CROSSABLE = "O";
    public static final String UNCROSSABLE = "X";
    public static final String NONE = " ";

    private final Bridge bridge;
    private List<String> top;
    private List<String> bottom;
    private int playCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.top = new ArrayList<>();
        this.bottom = new ArrayList<>();
        this.playCount = 0;
    }

    public boolean move(int idx, String input) {
        if (bridge.isMatch(idx, input)) {
            pass(input);
            return true;
        }
        fail(input);
        return false;
    }

    public void retry() {
        top.clear();
        bottom.clear();
        playCount += 1;
    }

    public void pass(String input) {
        if (input.equals(UP)) {
            top.add(CROSSABLE);
            bottom.add(NONE);
        }
        if (input.equals(DOWN)) {
            bottom.add(CROSSABLE);
            top.add(NONE);
        }
    }

    public void fail(String input) {
        if (input.equals(UP)) {
            top.add(UNCROSSABLE);
            bottom.add(NONE);
        }
        if (input.equals(DOWN)) {
            bottom.add(UNCROSSABLE);
            top.add(NONE);
        }
    }

    public boolean isClear() {
        return top.size() == bridge.size();
    }

    public int getPlayCount() {
        return playCount;
    }

    public List<String> getTop() {
        return top;
    }

    public List<String> getBottom() {
        return bottom;
    }
}
