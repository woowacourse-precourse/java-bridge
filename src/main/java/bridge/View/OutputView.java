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

    public void printMap(List<String> bridge, String direction, boolean passResult) {
        upperPath = stringify.getPathToString(bridge, UPPER_POSITION.toString());
        lowerPath = stringify.getPathToString(bridge, LOWER_POSITION.toString());

        if (!passResult) {
            upperPath = stringify.changeToFail(upperPath, UPPER_POSITION.toString(), direction);
            lowerPath = stringify.changeToFail(lowerPath, LOWER_POSITION.toString(), direction);
        }

        System.out.println(stringify.getPathStringForUser(upperPath, lowerPath));
    }
    public void printResult(boolean isNotArrived, int tryCount) {
        String result = getResultToString(isNotArrived);

        System.out.println(GAME_END.getMessage());
        System.out.println(stringify.getPathStringForUser(upperPath, lowerPath));
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
