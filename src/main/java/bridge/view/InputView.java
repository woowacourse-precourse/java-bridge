package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.util.BridgeConstant.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public final int MINIMUM_BRIDGE_SIZE = 3;
    public final int MAXIMUM_BRIDGE_SIZE = 20;
    public final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public final String INPUT_RETRY_OR_QUIT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printInputMessage(INPUT_BRIDGE_SIZE_MESSAGE);
        return getBridgeSize();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        printInputMessage(INPUT_MOVE_MESSAGE);
        return getBridgeMove();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        printInputMessage(INPUT_RETRY_OR_QUIT_MESSAGE);
        return getGameCommand().equals(GAME_RETRY_KEY);
    }

    private int getBridgeSize() {
        String readBridgeSize = Console.readLine();
        while (true) {
            try {
                validateBridgeSize(readBridgeSize);
                return Integer.parseInt(readBridgeSize);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
                readBridgeSize = Console.readLine();
            }
        }
    }

    private void validateBridgeSize(String readBridgeSize) {
        validateBridgeSizeIsNumber(readBridgeSize);
        validateBridgeSizeRange(readBridgeSize);
    }

    private void validateBridgeSizeIsNumber(String readBridgeSize) {
        try {
            Integer.parseInt(readBridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력되었습니다.");
        }
    }

    private void validateBridgeSizeRange(String readBridgeSize) {
        if (!validBridgeSize(Integer.parseInt(readBridgeSize))) {
            throw new IllegalArgumentException("3 이상 20 이하의 정수를 입력해야 합니다.");
        }
    }

    private boolean validBridgeSize(int readBridgeSize) {
        return MINIMUM_BRIDGE_SIZE <= readBridgeSize && readBridgeSize <= MAXIMUM_BRIDGE_SIZE;
    }

    private String getBridgeMove() {
        String readBridgeMove = Console.readLine();
        while (true) {
            try {
                validateBridgeMove(readBridgeMove);
                return readBridgeMove;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
                readBridgeMove = Console.readLine();
            }
        }
    }

    private void validateBridgeMove(String readBridgeMove) {
        if (!validateMoveRange(readBridgeMove)) {
            throw new IllegalArgumentException("이동 값으로는 `U` 혹은 `D`를 입력해야합니다.");
        }
    }

    private boolean validateMoveRange(String readBridgeMove) {
        return readBridgeMove.equals(DOWN_KEY) || readBridgeMove.equals(UP_KEY);
    }

    private String getGameCommand() {
        String readGameCommand = Console.readLine();
        while (true) {
            try {
                validateGameCommand(readGameCommand);
                return readGameCommand;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
                readGameCommand = Console.readLine();
            }
        }
    }

    private void validateGameCommand(String readGameCommand) {
        if (!validateCommandRange(readGameCommand)) {
            throw new IllegalArgumentException("");
        }
    }

    private boolean validateCommandRange(String readGameCommand) {
        return readGameCommand.equals(GAME_RETRY_KEY) || readGameCommand.equals(GAME_QUIT_KEY);
    }


    private void printInputMessage(String message) {
        System.out.println(message);
    }

    private void printErrorMessage(IllegalArgumentException e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
