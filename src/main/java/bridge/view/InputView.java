package bridge.view;

import java.util.regex.Pattern;

import bridge.constant.Direction;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private static final Pattern SINGLE_CHARACTER_PATTERN = Pattern.compile("[A-z]");

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    public Direction readDirection() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        validateSingleCharacter(input);
        return Direction.from(input);
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        validateSingleCharacter(input);
        validateCommand(input);
        return input;
    }

    private void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }

    private void validateSingleCharacter(String input) {
        if (!SINGLE_CHARACTER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("한 글자가 아닙니다");
        }
    }

    private void validateCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("잘못된 명령입니다");
        }
    }
}
