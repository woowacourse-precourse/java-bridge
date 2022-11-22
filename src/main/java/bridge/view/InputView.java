package bridge.view;


import bridge.message.ErrorMessage;
import bridge.message.PrintMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    /**
     * 사용자로부터 입력을 받는 역할을 한다.
     */
    public static int readBridgeSize() {
        PrintMessage.START_BRIDGE_GAME.printMessage();
        PrintMessage.INPUT_BRIDGE_SIZE.printMessage();

        int input = Integer.valueOf(readLine());
        if (!(3 <= input && input <= 20)) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_NOT_IN_RANGE.getMessage());
        }
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        PrintMessage.INPUT_DIRECTION.printMessage();
        String input = checkCharacter();
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.DIRECTION_NOT_U_D.getMessage());
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        PrintMessage.INPUT_RETRY.printMessage();
        String input = checkCharacter();
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException(ErrorMessage.RETRY_NOT_U_D.getMessage());
        }
        return input;
    }

    /**
     * 사용자가 입력한 값이 두 글자 이상인지 확인한다.
     */
    private static String checkCharacter() {
        String input = readLine();
        if (input.length() != 1) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ONLY_ONE.getMessage());
        }
        return input;
    }
}