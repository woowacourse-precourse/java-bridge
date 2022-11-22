package bridge.model;

import static bridge.constants.ResultMessage.*;

public enum movingOorX {
    cant(GAME_FAIL, GAME_X),
    can(GAME_SUCCESS, GAME_O);

    final private String movingMessage;
    final private String movingResult;

    public String getMovingMessage() {
        return movingMessage;
    }

    public String getMovingResult() {
        return movingResult;
    }

    movingOorX(String movingMessage, String movingResult) {
        this.movingMessage = movingMessage;
        this.movingResult = movingResult;
    }
}
