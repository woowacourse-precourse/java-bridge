package bridge;

import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.GET_SIZE);
        String input = Console.readLine();
        int size = 0;
        if (checkInputisNumber(input) == true) {
            size = Integer.parseInt(input);
            // throw new IllegalArgumentException();
        }
        if (checkBridgeSize(size) == false) {
            // throw new IllegalArgumentException();
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.GET_MOVE);
        String input = Console.readLine();
        if (checkInputisUpDown(input) == false) {
            return "";
            // throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Message.RESTART_GAME);
        String input = Console.readLine();
        if (validateCommand(input) == false) {
            // throw new IllegalArgumentException();
        }
        return input;
    }

    private boolean checkBridgeSize(int size) {
        if (size < 3 || size > 20) {
            System.out.println(Message.SIZE_RANGE_ERROR);
            return false;
            // throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean checkInputisNumber(String input) {
        String pattern = "^[0-9]+$";
        if (!Pattern.matches(pattern, input)) {
            System.out.println(Message.INPUT_NOT_NUMBER_ERROR);
            // throw new IllegalArgumentException(INPUT_NOT_NJMBER);
            return false;
        }
        return true;
    }

    private boolean checkInputisUpDown(String input) {
        if (input.equals("U") || input.equals("D")) {
            return true;
        }
        System.out.println(Message.INPUT_IS_U_OR_D_ERROR);
        return false;
    }

    private boolean validateCommand(String input) {
        if (input.equals("R") || input.equals("Q")) {
            return true;
        }
        System.out.println(Message.COMMAND_ERROR);
        return false;
    }
}
