package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String NOT_DIGITED_BRIDGE_SIZE_MESSAGE = "[ERROR] 다리 길이는 숫자여야 합니다.";
    private static final String NOT_IN_RANGED_BRIDGE_SIZE = "[ERROR] 다리 길이는 " + MIN_RANGE + "부터 " + MAX_RANGE + " 사이의 숫자여야 합니다.";
    private static final String INVALID_MOVING_MESSAGE = "[ERROR] 이동할 칸은 " + UP + " 또는 " + DOWN + " 문자여야 합니다.";
    private static final String INVALID_COMMAND_MESSAGE = "[ERROR] 다시 시도 여부는 " + RETRY + " 또는 " + QUIT + " 문자여야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
        String bridgeSize = Console.readLine();
        validateDigitedBridgeSize(bridgeSize);
        validateInRangedBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    private void validateDigitedBridgeSize(String bridgeSize) {
        for (int index = 0; index < bridgeSize.length(); index++) {
            if (!Character.isDigit(bridgeSize.charAt(index))) {
                throw new IllegalArgumentException(NOT_DIGITED_BRIDGE_SIZE_MESSAGE);
            }
        }
    }

    private void validateInRangedBridgeSize(String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < MIN_RANGE || MAX_RANGE < Integer.parseInt(bridgeSize)) {
            throw new IllegalArgumentException(NOT_IN_RANGED_BRIDGE_SIZE);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(INPUT_MOVING_MESSAGE);
        String selectMove = Console.readLine();
        validateMove(selectMove);
        return selectMove;
    }

    public void validateMove(String selectMove) {
        if (!(selectMove.equals(UP) || selectMove.equals(DOWN))) {
            throw new IllegalArgumentException(INVALID_MOVING_MESSAGE);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(INPUT_RETRY_MESSAGE);
        String selectCommand = Console.readLine();
        validateCommand(selectCommand);
        return selectCommand;
    }

    public void validateCommand(String selectMove) {
        if (!(selectMove.equals(RETRY) || selectMove.equals(QUIT))) {
            throw new IllegalArgumentException(INVALID_COMMAND_MESSAGE);
        }
    }
}
