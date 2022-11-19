package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Count;
import bridge.domain.PlayState;
import bridge.domain.Result;

public class BridgeGame {
    private static final String NO_BRIDGE_ERROR = "[ERROR] 다리가 생성되지 않아 게임이 만들어 지지 않아요";
    private static final String NO_START_GAME_ERROR = "[ERROR] 게임이 시작되지 않았습니다";
    private static final String RESTART_COMMAND = "R";
    public static final String QUIT_COMMAND = "Q";
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

    public void move(String input, int count) {
        updateResult(input, count);
    }

    public boolean retry(String input) {
        checkRestartQuitCommand(input);
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

    public boolean isNotBridgeLength(int crossCount) {
        checkBridge();
        return bridge.isNotSize(crossCount);
    }

    public boolean movable() {
        checkResult();
        return result.movable();
    }

    public Result recentResult() {
        checkResult();
        return this.result;
    }

    public String printPlayCount() {
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

    private void checkBridge() {
        if (bridge == null) {
            throw new IllegalStateException(NO_START_GAME_ERROR);
        }
    }

    private void checkState() {
        if (playState == null) {
            throw new IllegalStateException(NO_START_GAME_ERROR);
        }
    }

    private void checkRestartQuitCommand(String input) {
        if (!input.equals(RESTART_COMMAND) && !input.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException(" Q 또는 R을 입력해주세요");
        }
    }

    private void validate(Bridge bridge) {
        if (bridge == null) {
            throw new IllegalArgumentException(NO_BRIDGE_ERROR);
        }
    }
}
