package bridge.View;

import bridge.Enums.GameMessage;
import bridge.Utils.Stringify;

import java.util.List;

import static bridge.Enums.GameMessage.*;
import static bridge.Enums.View.*;

public class OutputView {
    private final Stringify stringify;

    private String upperPath;
    private String lowerPath;

    public OutputView (){
        stringify = new Stringify();
    }

    public void start() {
        System.out.println(GAME_START.getMessage());
    }

    public void printGetUserBridgeSize() {
        System.out.println(GET_USER_INPUT_BRIDGE_SIZE.getMessage());
    }

    public void printGetUserDirection() {
        System.out.println(GET_USER_MOVE_DIRECTION.getMessage());
    }

    public void printGetUserRetry() {
        System.out.println(GET_USER_RETRY_CHOICE.getMessage());
    }

    public void printMap(List<String> bridge, String direction, boolean isPassed) {
        String upper = stringify.getPathToString(bridge, UPPER_POSITION.toString());
        String lower = stringify.getPathToString(bridge, LOWER_POSITION.toString());
        if (!isPassed) {
            upper = stringify.changeToFail(upper, UPPER_POSITION.toString(), direction);
            lower = stringify.changeToFail(lower, LOWER_POSITION.toString(), direction);
        }

        upperPath = "[" + upper.substring(1) + "]";
        lowerPath = "[" + lower.substring(1) + "]\n";
        System.out.println(upperPath);
        System.out.println(lowerPath);
    }
    public void printResult(boolean isNotArrived, int tryCount) {
        String result = getResultToString(isNotArrived);

        System.out.println(GAME_END.getMessage());
        System.out.println(upperPath);
        System.out.println(lowerPath);
        System.out.println(GAME_RESULT.getMessage() + result);
        System.out.println(COUNT_OF_RETRY.getMessage() + tryCount);
    }

    private String getResultToString(boolean isNotArrived) {
        if (isNotArrived) {
            return GameMessage.FAIL.getMessage();
        }
        return GameMessage.SUCCESS.getMessage();
    }
}
