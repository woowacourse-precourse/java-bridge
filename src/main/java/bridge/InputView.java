package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final String BRIDGE_SIZE_NOT_DIGITS;
    private final String BRIDGE_SIZE_RANGE_OVER;
    private final String MOVING_INPUT_NOT_VALID;
    private final String GAME_COMMAND_NOT_VALID;

    InputView() {
        this.BRIDGE_SIZE_NOT_DIGITS = "[ERROR] 다리의 길이는 정수여야 합니다.";
        this.BRIDGE_SIZE_RANGE_OVER = "[ERROR] 다리의 길이는 3에서 20 사이여야 합니다.";
        this.MOVING_INPUT_NOT_VALID = "[ERROR] 플레이어가 이동할 칸은 U 또는 D여야 합니다.";
        this.GAME_COMMAND_NOT_VALID = "[ERROR] 재시작 여부 입력은 R 또는 Q여야 합니다.";
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        String command = Console.readLine();
        if (!isDigit(command)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_NOT_DIGITS);
        }
        int size = Integer.parseInt(command);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_OVER);
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        String command = Console.readLine();
        List<String> validCommands = List.of("U", "D");
        if (!validCommands.contains(command)) {
            throw new IllegalArgumentException(MOVING_INPUT_NOT_VALID);
        }
        return command;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private boolean isDigit(String size) {
        try {
            Integer.parseInt(size);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
