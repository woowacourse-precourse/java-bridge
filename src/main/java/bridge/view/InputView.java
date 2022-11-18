package bridge.view;

import bridge.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String ENTER_SPACE_WANT_TO_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String ENTER_RETRY_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String RETRY_OR_QUIT_FORMAT_ERROR = "R 또는 Q 를 입력해야합니다.";
    private static final String UP_AND_DOWN_FORMAT_ERROR = "U 또는 D 를 입력해야합니다.";


    private static String input() {
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE);
        return input();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(ENTER_SPACE_WANT_TO_MOVE);
        String answer = input();
        if (!InputValidator.checkUpAndDownValid(answer)) {
            throw new IllegalArgumentException(UP_AND_DOWN_FORMAT_ERROR);
        }
        return answer;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(ENTER_RETRY_OR_QUIT);
        String answer = input();
        if (!InputValidator.checkRetryOrQuitValid(answer)) {
            throw new IllegalArgumentException(RETRY_OR_QUIT_FORMAT_ERROR);
        }
        return answer;
    }
}
