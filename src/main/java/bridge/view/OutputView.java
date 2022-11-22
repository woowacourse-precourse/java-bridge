package bridge.view;

import bridge.domain.User;

import static bridge.constant.ConstValue.USER_DOWN_MOVING;
import static bridge.constant.ConstValue.USER_UP_MOVING;
import static bridge.constant.Message.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(User user) {
        System.out.println(makeMap(user, USER_UP_MOVING));
        System.out.println(makeMap(user, USER_DOWN_MOVING));
    }

    private String makeMap(User user, String direction) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        sb.append(makeMapMiddle(user, direction));
        sb.append(makeMapEnd(user, direction));

        return sb.toString();
    }

    private String makeMapEnd(User user, String direction) {
        return checkUserState(user, user.getUserLastIndex(), direction) + " ]";
    }

    private String makeMapMiddle(User user, String direction) {
        String middle = "";
        for (int i = 0; i < user.getUserLastIndex(); i++) {
            middle += checkUserState(user, i, direction);
            middle += " | ";
        }
        return middle;
    }

    private String checkUserState(User user, int index, String direction) {
        if (user.getUserMoveState(index).equals(direction)) {
            if (user.getMoveMatchState(index)) {
                return "O";
            }
            return "X";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, User user, int tryCount) {
        System.out.println(RESULT_MESSAGE);
        printMap(user);

        System.out.println();

        System.out.println(IS_SUCCESS_OR_FAIL + result);
        System.out.println(TRY_COUNT_MESSAGE + tryCount);
    }

    public void printBridgeSizeMessage() {
        System.out.println(BRIDGE_SIZE_MESSAGE);
    }

    public void printMovingMessage() {
        System.out.println(MOVE_INPUT_MESSAGE);
    }

    public void printRetryMessage() {
        System.out.println(RETRY_MESSAGE);
    }

    public void printGameStart() {
        System.out.println(GAME_START);
    }
}
