package bridge.view;

import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.\n";
    private static final String INPUT_BRIDGE_LOCATION = "이동할 칸을 선택해주세요. (위: U, 아래: D)\n";
    private static final String INPUT_RESTART_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n";
    private static final String DATA_TYPE_ERR_MESSAGE = "[ERROR] 숫자가 아닙니다.";

    public InputView() {
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        int size = convertStringtoInt(Console.readLine());
        try {
            Validator.isValidBridgeSize(size);
            return size;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(INPUT_BRIDGE_LOCATION);
        String moving = Console.readLine();
        try {
            Validator.isValidMoving(moving);
            return moving;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(INPUT_RESTART_QUIT);
        String command = Console.readLine();
        try {
            Validator.isValidGameCommand(command);
            return command;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private static int convertStringtoInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DATA_TYPE_ERR_MESSAGE);
        }
    }
}