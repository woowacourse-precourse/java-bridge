package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String BRIDGE_SIZE_ERROR = "정수만 입력 가능합니다.";
    private static final String COMMAND_ERROR = "명령어 형식이 올바르지 않습니다.";

    private static final String EMPTY_STRING = "";

    private static final Pattern COMMAND_PATTERN = Pattern.compile("^[a-zA-Z]$");

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);

        String input = Console.readLine();

        System.out.println(EMPTY_STRING);

        validateBridgeSize(input);
        return parseInt(input);
    }

    private void validateBridgeSize(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING);

        String input = Console.readLine();

        validateCommand(input);
        return input;
    }

    private void validateCommand(final String input) {
        if (!COMMAND_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(COMMAND_ERROR);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RETRY);

        String input = Console.readLine();

        validateCommand(input);
        return input;
    }
}
