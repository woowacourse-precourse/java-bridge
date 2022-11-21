package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.BridgeMaker.*;

public class BridgeGame {
    public static final String CROSSABLE = "O";
    public static final String UNCROSSABLE = "X";
    public static final String NONE = " ";
    public static final String RETRY = "R";
    public static final String END = "Q";

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

    public void move(int idx, String input) {
        if (bridge.isMatch(idx, input)) {
            pass(input);
        }
        fail(input);
    }

    public boolean retry(String input) {
        if (input.equals(RETRY)) {
            top.clear();
            bottom.clear();
            return true;
        }
        playCount += 1;
        return false;
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

    public int getBridgeSize() {
        return bridge.size();
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
