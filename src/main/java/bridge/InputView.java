package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Application.*;
import static bridge.Error.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        validateInputIsExist(input);
        validateInputSizeIsInteger(input);
        validateInputSizeIsInRange(input);

        return changeInputStringToInteger(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        validateInputIsExist(input);
        validateInputMovingCharacter(input);

        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        validateInputIsExist(input);
        validateInputGameCommandCharacter(input);

        return input;
    }

    private int changeInputStringToInteger(String input) {
        int size = 0;
        for (int i = 0; i < input.length(); i++) {
            size = size * 10 + input.charAt(i) - 48;
        }
        return size;
    }

    private void validateInputIsExist(String input) {
        if (input.length() == 0) {
            setError(NONE);
            throw new IllegalStateException();
        }
    }

    private void validateInputSizeIsInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 48 || input.charAt(i) > 57) {
                setError(INTEGER);
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateInputSizeIsInRange(String input) {
        int size = 0;
        for (int i = 0; i < input.length(); i++) {
            size = size * 10 + input.charAt(i) - 48;
        }
        if (size < 3 || size > 20) {
            setError(RANGE);
            throw new IllegalArgumentException();
        }
    }

    private void validateInputMovingCharacter(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            setError(CHARACTER);
            throw new IllegalArgumentException();
        }
    }

    private void validateInputGameCommandCharacter(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            setError(CHARACTER);
            throw new IllegalArgumentException();
        }
    }
}
