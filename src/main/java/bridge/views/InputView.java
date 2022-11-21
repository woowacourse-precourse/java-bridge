package bridge.views;

import bridge.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String REQUEST_MOVING_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String REQUEST_RESTART_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() throws IllegalArgumentException {
        System.out.println(REQUEST_BRIDGE_SIZE);
        String input = Console.readLine();
        Validator.validateBridgeSize(input);
        System.out.println();
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() throws IllegalArgumentException {
        System.out.println(REQUEST_MOVING_DIRECTION);
        String input = Console.readLine();
        Validator.isUOrD(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() throws IllegalArgumentException {
        System.out.println(REQUEST_RESTART_OR_QUIT);
        String input = Console.readLine();
        Validator.isROrQ(input);
        return input;
    }
}
