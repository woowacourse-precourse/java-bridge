package bridge.view;

import static bridge.constant.Direction.LOWER;
import static bridge.constant.Direction.UPPER;
import static bridge.constant.GameCommand.EXIT;
import static bridge.constant.GameCommand.RETRY;

import java.util.regex.Pattern;

import bridge.constant.Direction;
import bridge.constant.GameCommand;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private static final Pattern SINGLE_CHARACTER_PATTERN = Pattern.compile("[A-z]");

    private static final String DIRECTION_PROMPT_MESSAGE_FORMAT = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)\n";
    private static final String GAME_COMMAND_PROMPT_MESSAGE_FORMAT =
            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)\n";

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    public Direction readDirection() {
        System.out.printf(DIRECTION_PROMPT_MESSAGE_FORMAT, UPPER.capitalLetter(), LOWER.capitalLetter());
        String input = Console.readLine();
        validateSingleCharacter(input);
        return Direction.from(input);
    }

    public GameCommand readGameCommand() {
        System.out.printf(GAME_COMMAND_PROMPT_MESSAGE_FORMAT, RETRY.getCharacter(), EXIT.getCharacter());
        String input = Console.readLine();
        validateSingleCharacter(input);
        return GameCommand.from(input);
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
}
