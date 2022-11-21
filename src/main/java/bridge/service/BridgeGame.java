package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Count;
import bridge.domain.PlayState;
import bridge.domain.Result;

public class BridgeGame {
    private static final String UP_DOWN_ERROR = "[ERROR] U 또는 D를 입력해주세요";
    private static final String RESTART_QUIT_ERROR = "[ERROR] Q 또는 R을 입력해주세요";
    private static final String NO_BRIDGE_ERROR = "[ERROR] 다리가 생성되지 않아 게임이 만들어 지지 않아요";
    private static final String NO_START_GAME_ERROR = "[ERROR] 비정상적인 접근이에요";
    private static final String RESTART_COMMAND = "R";
    public static final String QUIT_COMMAND = "Q";
    private static final String UP_COMMAND = "U";
    private static final String DOWN_COMMAND = "D";
    private PlayState playState;
    private Count count;
    private Bridge bridge;
    private Result result;

    public BridgeGame() {
    }

    public BridgeGame(Bridge bridge) {
        validate(bridge);
        this.bridge = bridge;
        this.result = new Result();
        this.playState = new PlayState(true);
        this.count = new Count();
    }

    public Result move(String input, int count) {
        checkUpDown(input);
        updateResult(input, count);
        return result;
    }

    public boolean retry(String input) {
        checkRestartQuitCommand(input);
        checkResult();
        if (input.equals(RESTART_COMMAND)) {
            this.result = new Result();
            count = count.increase();
            return playState.nowState();
        }
        end();
        return playState.nowState();
    }

    public void end() {
        checkState();
        playState = playState.end();
    }

    public boolean state() {
        checkState();
        return playState.nowState();
    }

    public boolean movable() {
        checkResult();
        return result.movable();
    }

    public boolean checkCross() {
        checkResult();
        return bridge.isNotSize(result.stateSize());
    }

    public Result recentResult() {
        checkResult();
        return this.result;
    }

    public String printPlayCount() {
        checkCount();
        return count.printCount();
    }

    private void updateResult(String input, int index) {
        checkResult();
        if (bridge.movable(input, index)) {
            result.updateState(input, true);
        }
        if (!bridge.movable(input, index)) {
            result.updateState(input, false);
        }
    }

    private void checkResult() {
        if (result == null) {
            throw new IllegalStateException(NO_START_GAME_ERROR);
        }
    }

    private void checkState() {
        if (playState == null) {
            throw new IllegalStateException(NO_START_GAME_ERROR);
        }
    }

    private void checkCount() {
        if (count == null) {
            throw new IllegalStateException(NO_START_GAME_ERROR);
        }
    }

    private void checkUpDown(String input) {
        if (!input.equals(UP_COMMAND) && !input.equals(DOWN_COMMAND)) {
            throw new IllegalArgumentException(UP_DOWN_ERROR);
        }
    }

    private void checkRestartQuitCommand(String input) {
        if (!input.equals(RESTART_COMMAND) && !input.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException(RESTART_QUIT_ERROR);
        }
    }

    private void validate(Bridge bridge) {
        if (bridge == null) {
            throw new IllegalArgumentException(NO_BRIDGE_ERROR);
        }
    }
}
