package bridge.view;

import bridge.model.Plate;
import bridge.util.Errors;
import bridge.util.Rules;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String ASK_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String ASK_NEXT_STEP = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(ASK_BRIDGE_SIZE);
        String input = readString();
        validateNumberType(input);
        return Integer.parseInt(input);
    }

    private void validateNumberType(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(Errors.ERROR_INPUT_NOT_NUMBER_TYPE.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
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

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private String readString() {
        return Console.readLine().trim();
    }
}
