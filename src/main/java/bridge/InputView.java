package bridge;

import static bridge.MessageView.*;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        return validateBridgeSize(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_DIRECTION);
        return validateMoving(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RETRY_COMMAND);
        return validateGameCommand(Console.readLine());
    }

    private int validateBridgeSize(String size) {
        int num = 0;
        if(isNumeric(size)) {
            num = Integer.parseInt(size);
        }
        if (num < 3 || num > 20) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
        return num;
    }

    private String validateMoving(String moving) {
        if (!(moving.equals("U") || moving.equals("D"))) {
            throw new IllegalArgumentException(INVALID_DIRECTION);
        }
        return moving;
    }

    private String validateGameCommand(String command) {
        if (!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException(INVALID_COMMAND);
        }
        return command;
    }

    private boolean isNumeric(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException(INVALID_INPUT_NUMBER);
            }
        }
        return true;
    }
}