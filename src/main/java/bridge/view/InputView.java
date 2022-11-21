package bridge.view;

import java.util.Arrays;
import java.util.regex.Pattern;

import bridge.constant.Direction;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    private void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        validateSingleCharacter(input);
        validateDirection(input);
        return input;
    }

    private void validateSingleCharacter(String input) {
        if (Pattern.compile("\\w").matcher(input).matches()) {
            throw new IllegalArgumentException("한 글자가 아닙니다");
        }
    }

    private void validateDirection(String input) {
        Arrays.stream(Direction.values())
                .filter(direction -> direction.capitalLetter().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 방향입니다"));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        validateSingleCharacter(input);
        validateCommand(input);
        return input;
    }

    private void validateCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("잘못된 명령입니다");
        }
    }
}
