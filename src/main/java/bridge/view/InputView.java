package bridge.view;

import static bridge.view.SystemMessage.*;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(SystemMessage.BRIDGE_SIZE_INPUT_MESSAGE);
        String temp = Console.readLine();
        int size = validateNumber(temp);
        validateLimit(size);
        return size;
    }

    private static Integer validateNumber(String size) {
        return Integer.parseInt(size);
    }


    private static void validateLimit(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BRIDGE_SIZE_LIMIT_ERROR_MESSAGE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(SystemMessage.MOVING_SPACE_INPUT_MESSAGE);
        String moving_space = Console.readLine();
        validateMoving(moving_space);
        return moving_space;
    }

    private static void validateMoving(String moving_space) {
        if (!moving_space.equals("U") && !moving_space.equals("D")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + MOVING_CAMMAND_ERROR_MESSAGE);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {

        System.out.println(SystemMessage.RETRY_GAME_INPUT_MESSAGE);
        String command = Console.readLine();
        validateCommand(command);
        return command;
    }

    private static void validateCommand(String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + RETRY_OR_GAME_OVER_CAMMAND_ERROR_MESSAGE);
        }
    }

}
