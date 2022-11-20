package bridge.domain;

import bridge.constant.GameState;
import bridge.view.InputView;

public class JudgeDestination {

    private GameState statement = new GameState();
    private final Boolean GAME_OVER = false;
    private final Boolean RESTART = true;

    public boolean judgeRestartOrOver(String input) {
        String destination = input;
        if (destination.equals(statement.QUIT)) {
            return GAME_OVER;
        }
        return RESTART;
    }


}
