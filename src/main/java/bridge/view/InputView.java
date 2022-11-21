package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;
    private static final String MOVE_COMMAND_UP = "U";
    private static final String MOVE_COMMAND_DOWN = "D";
    private static final String FAIL_COMMAND_RETRY = "R";
    private static final String FAIL_COMMAND_QUIT = "Q";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        boolean validBridgeSize = false;
        String inputBridgeSize = null;

        while (!validBridgeSize) {
            System.out.println("다리의 길이를 입력해주세요.");
            inputBridgeSize = Console.readLine();
            validBridgeSize = isValidBridgeSize(inputBridgeSize);
        }

        return Integer.parseInt(inputBridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        boolean validMoveCommand = false;
        String inputMoveCommand = null;

        while (!validMoveCommand) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            inputMoveCommand = Console.readLine();
            validMoveCommand = isValidMoveCommand(inputMoveCommand);
        }
        return inputMoveCommand;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        boolean validFailCommand = false;
        String inputFailCommand = null;

        while (!validFailCommand) {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            inputFailCommand = Console.readLine();
            validFailCommand = isValidFailCommand(inputFailCommand);
        }
        return inputFailCommand;
    }

    private boolean isValidBridgeSize(String bridgeSize) {
        try {
            validateInteger(bridgeSize);
            validateBridgeSizeRange(Integer.parseInt(bridgeSize));
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void validateInteger(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize >= BRIDGE_SIZE_MIN && bridgeSize >= BRIDGE_SIZE_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidMoveCommand(String moveCommand) {
        try {
            validateMoveFormat(moveCommand);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;

    }


    private void validateMoveFormat(String moveCommand) {
        if (!moveCommand.equals(MOVE_COMMAND_UP) && !moveCommand.equals(MOVE_COMMAND_DOWN)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidFailCommand(String failCommand) {
        try {
            validateGameFailFormat(failCommand);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void validateGameFailFormat(String failCommand) {
        if (!failCommand.equals(FAIL_COMMAND_RETRY) && !failCommand.equals(FAIL_COMMAND_QUIT)) {
            throw new IllegalArgumentException();
        }
    }
}
