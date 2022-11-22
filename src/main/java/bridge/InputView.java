package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            System.out.println(PrintWord.BRIDGE_LENGTH);
            String inputSize = Console.readLine();
            return validateInputSize(inputSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private static int validateInputSize(String inputSize) {
        if (!Pattern.matches("^[3-9]|1[0-9]|20", inputSize)) {
            throw new IllegalArgumentException(ErrorWord.INPUT_SIZE);
        }
        return Integer.parseInt(inputSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        try {
            System.out.println(PrintWord.SELECT_MOVE);
            String inputMoving = Console.readLine();
            return validateInputMoving(inputMoving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private static String validateInputMoving(String inputMoving) {
        if (!Pattern.matches("^[UD]", inputMoving)) {
            throw new IllegalArgumentException(ErrorWord.INPUT_MOVING);
        }
        return inputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        try {
            System.out.println(PrintWord.SELECT_RETRY);
            String inputCommand = Console.readLine();
            return validateInputCommand(inputCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private static String validateInputCommand(String inputCommand) {
        if (!Pattern.matches("^[RQ]", inputCommand)) {
            throw new IllegalArgumentException(ErrorWord.INPUT_RETRY);
        }
        return inputCommand;
    }
}
