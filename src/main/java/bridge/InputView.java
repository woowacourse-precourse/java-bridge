package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = Console.readLine();
        return validateNumberRange(validateNumber(userInput));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInput = Console.readLine();
        validateLength(userInput);
        validateUorD(userInput);
        return userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInput = Console.readLine();
        validateLength(userInput);
        validateRorQ(userInput);
        return userInput;
    }

    private void validateLength(String input) {
         if (input.length() != 1) {
             throw new IllegalArgumentException("[ERROR] 잘못된 값이 입력되었습니다.");
         }
    }

    private int validateNumber(String input) {
        String REGEX = "[0-9]+";
        if(!input.matches(REGEX)) {
            throw new IllegalArgumentException("[ERROR] 입력된 내용이 숫자가 아닙니다.");
        }
        return Integer.parseInt(input);
    }

    private int validateNumberRange(int number) {
        if(number < 3 || number > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return number;
    }
    private void validateUorD(String input) {
        if (!List.of("U","D").contains(input)) {
            throw new IllegalArgumentException("[ERROR] 다리는 U 또는 D를 입력하여 건널 수 있습니다.");
        }
    }
    private void validateRorQ(String input) {
        if (!List.of("R","Q").contains(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 명령어가 입력되었습니다.");
        }
    }
}
