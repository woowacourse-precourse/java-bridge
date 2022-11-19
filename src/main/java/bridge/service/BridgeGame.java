package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Result;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private boolean playingState = true;
    private int playCount = 1;
    private Bridge bridge;
    private Result result;

    public BridgeGame() {
    }

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.result = new Result();
    }

    public void move(String input, int count) {
        updateResult(input, count);
    }

    public boolean retry(String input) {
        if (input.equals("R")) {
            this.result = new Result();
            playCount++;
            return true;
        }
        playingState = false;
        return false;
    }

    public void end() {
        this.playingState = false;
    }

    public void newResult() {
        this.result = new Result();
    }

    public boolean state() {
        return playingState;
    }

    private void updateResult(String input, int index) {
        if (bridge.movable(input, index)) {
            result.updateState(input, true);
        }
        if (!bridge.movable(input, index)) {
            result.updateState(input, false);
        }
    }

    public boolean isBridgeLength(int crossCount) {
        return bridge.isSize(crossCount);
    }

    public boolean crossState() {
        return result.movable();
    }

    public Result recentResult() {
        return this.result;
    }

    public String printPlayCount() {
        return String.valueOf(playCount);
    }
}
