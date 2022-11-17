package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.BridgeCellType;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    private static final String NOT_INT_MESSAGE = "입력이 정수가 아닙니다. 정수를 입력해 주세요.";

    private static final String INVALID_BRIDGE_CELL_TYPE_MESSAGE = "이동할 칸이 올바르지 않습니다. (U or D)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
        String input = readLine();
        return getAnInt(input);
    }

    private int getAnInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INT_MESSAGE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVE_MESSAGE);
        String input = readLine();
        validateMove(input);
        return input;
    }

    private void validateMove(String input) {
        if (BridgeCellType.isNotBridgeCellType(input)) {
            throw new IllegalArgumentException(INVALID_BRIDGE_CELL_TYPE_MESSAGE);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
