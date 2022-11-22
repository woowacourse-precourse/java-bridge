package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "이동한 칸을 선택해주세요. (위: U, 아래: D)";

    private static final int BRIDGE_MIN_RANGE = 3;
    private static final int BRIDGE_MAX_RANGE = 20;

    private static final String UP_COMMAND = "U";
    private static final String DOWN_COMMAND = "D";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        String inputBridgeSize = Console.readLine();
        validateInputBridgeSize(inputBridgeSize);

        return Integer.parseInt(inputBridgeSize);
    }

    private void validateInputBridgeSize(String inputBridgeSize) {
        validateNumberFormat(inputBridgeSize);
        validateRange(Integer.parseInt(inputBridgeSize));
    }

    private void validateNumberFormat(String inputValue) {
        try {
            Integer.valueOf(inputValue);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private void validateRange(int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_RANGE || bridgeSize > BRIDGE_MAX_RANGE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVE_MESSAGE);
        String inputMoveDirection = Console.readLine();
        validateMovingDirection(inputMoveDirection);

        return inputMoveDirection.toUpperCase();
    }

    private void validateMovingDirection(String inputMoveDirection) {
        validateMoveCommand(inputMoveDirection.trim());
    }

    private void validateMoveCommand(String inputMoveDirection) {
        if (!inputMoveDirection.equalsIgnoreCase(UP_COMMAND) && !inputMoveDirection.equalsIgnoreCase(DOWN_COMMAND)) {
            throw new IllegalArgumentException("[ERROR] U 또는 D 값만 입력해야 합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
