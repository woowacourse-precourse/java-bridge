package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_MESSAGE = "이동한 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final int BRIDGE_MIN_RANGE = 3;
    private static final int BRIDGE_MAX_RANGE = 20;
    private static final String UP_COMMAND = "U";
    private static final String DOWN_COMMAND = "D";
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

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
        validateMoveCommand(inputMoveDirection.trim());

        return inputMoveDirection;
    }

    private void validateMoveCommand(String inputMoveDirection) {
        if (!inputMoveDirection.equals(UP_COMMAND) && !inputMoveDirection.equals(DOWN_COMMAND)) {
            throw new IllegalArgumentException("[ERROR] U 또는 D 값만 입력해야 합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RETRY_MESSAGE);
        String inputGameCommand = Console.readLine();
        validateGameCommand(inputGameCommand.trim());

        return inputGameCommand;
    }

    private void validateGameCommand(String inputGameCommand) {
        if (!inputGameCommand.equals(RETRY_COMMAND) && !inputGameCommand.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q 값만 입력해야 합니다.");
        }
    }
}
