package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String regex = "^[0-9]+$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = readInput(Sentence.INPUT_LENGTH);
        System.out.println();

        validateNumber(input);
        return stringToInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return readInput(Sentence.INPUT_SPACE);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return readInput(Sentence.INPUT_END);
    }

    private String readInput(Sentence sentence) {
        System.out.println(sentence.toString());
        String input = Console.readLine().trim();
        return input;
    }

    private int stringToInt(String target) {
        return Integer.parseInt(target);
    }

    private void validateNumber(String target) {
        if (!Pattern.matches(regex, target)) {
            throw new IllegalArgumentException(Error.INCLUDE_CAHRACTER.toString());
        }
    }
}
