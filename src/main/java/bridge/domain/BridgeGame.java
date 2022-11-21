package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.BridgeMaker.*;

public class BridgeGame {
    private final Bridge bridge;
    private List<PassResult> top;
    private List<PassResult> bottom;
    private int playCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.top = new ArrayList<>();
        this.bottom = new ArrayList<>();
        this.playCount = 1;
    }

    public boolean move(int idx, Direction direction) {
        if (bridge.isMatch(idx, direction)) {
            pass(direction);
            return true;
        }
        fail(direction);
        return false;
    }

    public boolean retry(Command command) {
        if (command.equals(Command.RETRY)) {
            top.clear();
            bottom.clear();
            playCount += 1;
            return true;
        }
        return false;
    }

    public void pass(Direction direction) {
        if (direction.equals(Direction.UP)) {
            top.add(PassResult.PASS);
            bottom.add(PassResult.NONE);
        }
        if (direction.equals(Direction.DOWN)) {
            bottom.add(PassResult.PASS);
            top.add(PassResult.NONE);
        }
    }

    public void fail(Direction direction) {
        if (direction.equals(Direction.UP)) {
            top.add(PassResult.FAIL);
            bottom.add(PassResult.NONE);
        }
        if (direction.equals(Direction.DOWN)) {
            bottom.add(PassResult.FAIL);
            top.add(PassResult.NONE);
        }
    }

    public boolean isClear() {
        long topCount = top.stream().filter(t -> t.equals(CROSSABLE)).count();
        long bottomCount = this.bottom.stream().filter(b -> b.equals(CROSSABLE)).count();
        return topCount + bottomCount == bridge.size();
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
