package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final Bridge bridge;
    private List<MoveResult> top;
    private List<MoveResult> bottom;
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
            top.add(MoveResult.PASS);
            bottom.add(MoveResult.NONE);
        }
        if (direction.equals(Direction.DOWN)) {
            bottom.add(MoveResult.PASS);
            top.add(MoveResult.NONE);
        }
    }

    public void fail(Direction direction) {
        if (direction.equals(Direction.UP)) {
            top.add(MoveResult.FAIL);
            bottom.add(MoveResult.NONE);
        }
        if (direction.equals(Direction.DOWN)) {
            bottom.add(MoveResult.FAIL);
            top.add(MoveResult.NONE);
        }
    }

    public GameResult isClear() {
        long topCount = top.stream().filter(t -> t.equals(MoveResult.PASS)).count();
        long bottomCount = bottom.stream().filter(b -> b.equals(MoveResult.PASS)).count();
        if (topCount + bottomCount == bridge.size()) {
            return GameResult.SUCCESS;
        }
        return GameResult.FAIL;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public int getPlayCount() {
        return playCount;
    }

    public List<MoveResult> getTop() {
        return top;
    }

    public List<MoveResult> getBottom() {
        return bottom;
    }
}
