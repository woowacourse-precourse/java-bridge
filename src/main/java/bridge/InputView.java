package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String GAME_STARTING_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String CHOOSE_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 다리의 길이는 3 이상 20이하의 숫자여야 합니다.";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력해주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        printBridgeLength();
        String input = Console.readLine();
        int size = convertNumeric(input);
        validateBridgeSize(size);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public void printStartGame() {
        System.out.println(GAME_STARTING_MESSAGE);
    }

    public void printBridgeLength() {
        System.out.println(BRIDGE_LENGTH_MESSAGE);
    }

    public void printChooseMoving() {
        System.out.println(CHOOSE_MOVING_MESSAGE);
    }

    private void validateBridgeSize(int size) throws IllegalArgumentException {
        if ((size < 3) || (size > 20)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    private int convertNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }
}
