package bridge.domain;

import bridge.constant.GameState;

public class JudgeDestination {

    private final Boolean GAME_OVER = false;
    private final Boolean RESTART = true;

    public boolean judgeRestartOrOver(String input) {
        String destination = input;
        if (destination.equals(GameState.QUIT)) {
            return GAME_OVER;
        }
        return RESTART;
    }


}
