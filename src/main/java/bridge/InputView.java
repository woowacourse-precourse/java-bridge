package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String regex = "^[0-9]+$";
    private static final int MIN_VALUE = 3;
    private static final int MAX_VALUE = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = readInput(Sentence.INPUT_LENGTH);
        System.out.println();
        validateNumber(input);
        int number = stringToInt(input);
        validateNumberRange(number);
        return number;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = readInput(Sentence.INPUT_SPACE);
        validateMove(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = readInput(Sentence.INPUT_END);
        validateEnd(input);
        return input;
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

    private void validateNumberRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(Error.OUT_OF_RANGE.toString());
        }
    }

    private void validateMove(String target) {
        if (!Objects.equals(target, Input.UP.toString()) && !Objects.equals(target, Input.DOWN.toString())) {
            throw new IllegalArgumentException(Error.UP_OR_DOWN.toString());
        }
    }

    private void validateEnd(String target) {
        if (!Objects.equals(target, Input.RETRY.toString()) && !Objects.equals(target, Input.QUIT.toString())) {
            throw new IllegalArgumentException(Error.UP_OR_DOWN.toString());
        }
    }
}
