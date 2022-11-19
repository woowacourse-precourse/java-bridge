package bridge.View;

import bridge.Enums.GameMessage;
import bridge.Utils.Stringify;

import java.util.List;

import static bridge.Enums.GameMessage.*;
import static bridge.Enums.View.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * (추가) InputView의 부모클래스가 된다. InputView에서 입력을 받을때 관련된 메세지를 출력한다.
 */
public class OutputView {
    private final Stringify stringify = new Stringify();

    private String upperPath;
    private String lowerPath;

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

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
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
