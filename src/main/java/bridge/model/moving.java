package bridge.model;

import static bridge.constants.ResultMessage.*;
import static bridge.constants.ResultMessage.GAME_O;

public enum moving {

    down(0, "D"),
    up(1, "U");


    final private Integer movingNum;
    final private String upDown;

    public Integer getMovingNum() {
        return movingNum;
    }

    public String getUpDown() {
        return upDown;
    }

    moving(Integer movingNum, String upDown) {
        this.movingNum = movingNum;
        this.upDown = upDown;
    }
}
