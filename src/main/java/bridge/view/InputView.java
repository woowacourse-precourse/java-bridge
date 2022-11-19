package bridge.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String GET_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String GET_PLAYER_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GET_GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String STRING_REGEX = "^[a-zA-Z]*$";
    private static final String NUMBER_REGEX = "^[1-9]*$";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요 : %s";
    private static final String STRING_FORMAT_ERROR_MESSAGE = "[ERROR] 문자만 입력해주세요 : %s";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 빈 문자열은 입력될 수 없습니다.";
    private static final String FORMAT_OPTION_ERROR_MESSAGE = "[ERROR] %s 또는 %s를 입력해주세요";
    private static final String GAME_REPLAY = "R";
    private static final String GAME_QUIT = "Q";
    private static final String UP_STAIR = "U";
    private static final String DOWN_STAIR = "D";


    public static int readBridgeSize() {
        System.out.println(GET_BRIDGE_SIZE_MESSAGE);
        String input = Console.readLine();
        validateNumberForm(input);
        return Integer.parseInt(input);
    }

    private static void validateNumberForm(String input) {
        validateBlank(input);
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            throw new IllegalArgumentException(String.format(NUMBER_FORMAT_ERROR_MESSAGE, input));
        }
    }

    public static String readMoving() {
        System.out.println(GET_PLAYER_MOVE_MESSAGE);
        String input = Console.readLine();
        validate(input, UP_STAIR, DOWN_STAIR);
        return input;
    }

    public static boolean readGameCommand() {
        System.out.println(GET_GAME_COMMAND_MESSAGE);
        String input = Console.readLine();
        validate(input, GAME_REPLAY, GAME_QUIT);
        return input.equals(GAME_REPLAY);
    }

    private static void validate(String input, String option, String otherOption) {
        validateBlank(input);
        validateStringForm(input);
        validateOption(input, option, otherOption);
    }

    private static void validateStringForm(String input) {
        if (!Pattern.matches(STRING_REGEX, input)) {
            throw new IllegalArgumentException(String.format(STRING_FORMAT_ERROR_MESSAGE, input));
        }
    }

    private static void validateOption(String input, String format1, String format2) {
        if (!input.equals(format1) && !input.equals(format2)) {
            throw new IllegalArgumentException(
                String.format(FORMAT_OPTION_ERROR_MESSAGE, format1, format2));
        }
    }

    private static void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

}
