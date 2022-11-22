package bridge.view;

import bridge.Constants;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printMessage(Constants.INPUT_BRIDGE_SIZE);
        String input = Console.readLine();
        validateNumber(input);
        String newLine = "";
        printMessage(newLine);
        return Integer.parseInt(input);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void validateNumber(String input) {
        final String ONLY_NUMBER_REGEX = "^[0-9]+$";
        if (!Pattern.matches(ONLY_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        printMessage(Constants.INPUT_MOVING);
        String input = Console.readLine();
        validateMoving(input);
        return input;
    }

    private void validateMoving(String input) {
        if (!(input.equals(Constants.UP) || input.equals(Constants.DOWN))) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        printMessage(Constants.INPUT_GAME_COMMAND);
        String input = Console.readLine();
        validateGameCommand(input);
        return input;
    }

    private void validateGameCommand(String input) {
        if (!(input.equals(Constants.RETRY) || input.equals(Constants.QUIT))) {
            throw new IllegalArgumentException();
        }
    }
}
