package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Count;
import bridge.domain.PlayState;
import bridge.domain.Result;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private PlayState playState;
    private Count count;
    private Bridge bridge;
    private Result result;

    public BridgeGame() {
    }

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.result = new Result();
        this.playState = new PlayState(true);
        this.count = new Count();
    }

    public void move(String input, int count) {
        updateResult(input, count);
    }

    public boolean retry(String input) {
        if (input.equals("R")) {
            this.result = new Result();
            count = count.increase();
            return playState.nowState();
        }
        end();
        return playState.nowState();
    }

    public void end() {
        playState.end();
    }

    public void newResult() {
        this.result = new Result();
    }

    public boolean state() {
        return playState.nowState();
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
        if (result == null) {
            throw new IllegalStateException("[ERROR] 게임이 시작되지 않았습니다");
        }
        return this.result;
    }

    public String printPlayCount() {
        return count.printCount();
    }
}
