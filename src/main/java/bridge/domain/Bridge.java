package bridge.domain;

import static bridge.constant.BridgeOutput.*;
import static bridge.constant.GameResult.FAILURE;
import static bridge.constant.GameResult.SUCCESS;

public class Bridge {

    private static String upBridge = INITIAL_SETTING;
    private static String downBridge = INITIAL_SETTING;

    public void succeedUpMovement() {
        upBridge = upBridge.replace(END_POINT, SUCCESS.getNowCondition());
        downBridge = downBridge.replace(END_POINT, EMPTY);
    }

    public void succeedDownMovement() {
        upBridge = upBridge.replace(END_POINT, EMPTY);
        downBridge = downBridge.replace(END_POINT, SUCCESS.getNowCondition());
    }

    public void failUpMovement() {
        upBridge = upBridge.replace(END_POINT, FAILURE.getNowCondition());
        downBridge = downBridge.replace(END_POINT, EMPTY);
    }

    public void failDownMovement() {
        upBridge = upBridge.replace(END_POINT, EMPTY);
        downBridge = downBridge.replace(END_POINT, FAILURE.getNowCondition());
    }

    public void replaceUnnecessaryBridge() {
        upBridge = upBridge.replace(CHANGE_POINT, FIRST_POINT);
        downBridge = downBridge.replace(CHANGE_POINT, FIRST_POINT);
    }

    public String getUpBridge() {
        return upBridge;
    }

    public String getDownBridge() {
        return downBridge;
    }

    public void setUpBridge() {
        upBridge = INITIAL_SETTING;
    }

    public void setDownBridge() {
        downBridge = INITIAL_SETTING;
    }
}
