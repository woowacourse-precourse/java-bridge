package bridge;

import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static String SIZE_RANGE_ERROR = "[ERROR] size out of range";
    private static String INPUT_NOT_NUMBER_ERROR = "[ERROR] input is not number";
    private static String INPUT_IS_U_OR_D_ERROR = "[ERROR] input must be U or D";
    private static String COMMAND_ERROR = "[ERROR] command must be R or Q";

    private static String GET_SIZE = "다리의 길이를 입력해주세요.";
    private static String GET_MOVE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static String RESTART_GAME = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(GET_SIZE);
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
        System.out.println(GET_MOVE);
        String input = Console.readLine();
        if (checkInputisUpDown(input) == false) {
            // throw new IllegalArgumentException();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RESTART_GAME);
        String input = Console.readLine();
        if (validateCommand(input) == false) {
            // throw new IllegalArgumentException();
        }
        return input;
    }

    private boolean checkBridgeSize(int size) {
        if (size < 3 || size > 20) {
            System.out.println(SIZE_RANGE_ERROR);
            return false;
            // throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean checkInputisNumber(String input) {
        String pattern = "^[0-9]+$";
        if (!Pattern.matches(pattern, input)) {
            System.out.println(INPUT_NOT_NUMBER_ERROR);
            // throw new IllegalArgumentException(INPUT_NOT_NJMBER);
            return false;
        }
        return true;
    }

    private boolean checkInputisUpDown(String input) {
        if (input.equals("U") || input.equals("D")) {
            return true;
        }
        System.out.println(INPUT_IS_U_OR_D_ERROR);
        return false;
    }

    private boolean validateCommand(String input) {
        if (input.equals("R") || input.equals("Q")) {
            return true;
        }
        System.out.println(COMMAND_ERROR);
        return false;
    }
}
