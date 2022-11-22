package bridge.view;

import bridge.util.Errors;
import bridge.util.Rules;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String ASK_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String ASK_NEXT_STEP = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String ASK_RETRY_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private String readString() {
        String input = Console.readLine().trim();
        return inputToUpperCase(input);
    }

    private String inputToUpperCase(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int inputIndex = 0; inputIndex < input.length(); inputIndex++) {
            char upperCase = Character.toUpperCase(input.charAt(inputIndex));
            stringBuilder.append(upperCase);
        }
        return stringBuilder.toString();
    }

    public int readBridgeSize() {
        System.out.println(ASK_BRIDGE_SIZE);
        String input = readString();
        validateNumberType(input);
        System.out.println();
        return Integer.parseInt(input);
    }

    private void validateNumberType(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(Errors.ERROR_INPUT_NOT_NUMBER_TYPE.getMessage());
        }
    }

    public String readMoving() {
        System.out.println(ASK_NEXT_STEP);
        String input = readString();
        validateUpDown(input);
        return input;
    }

    private void validateUpDown(String input) {
        if (isNotUorD(input)) {
            throw new IllegalArgumentException(Errors.ERROR_INPUT_UP_OR_DOWN.getMessage());
        }
    }

    private boolean isNotUorD(String input) {
        return !input.matches(
                Rules.PLATE_DOWN_PLATE_SYMBOL
                        + "|" + Rules.PLATE_UP_PLATE_SYMBOL);
    }

    public String readGameCommand() {
        System.out.println(ASK_RETRY_GAME);
        String input = readString();
        validateRetryQuit(input);
        return input;
    }

    private void validateRetryQuit(String input) {
        if (isRorQ(input)) {
            throw new IllegalArgumentException(Errors.ERROR_GAME_RETRY_OR_QUIT.getMessage());
        }
    }

    private boolean isRorQ(String input) {
        return !input.matches(
                Rules.GAME_RETRY
                        + "|" + Rules.GAME_QUIT);
    }
}
