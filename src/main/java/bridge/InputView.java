package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final String INPUT_NUMBER_ERROR_SENTENCE = "[ERROR] 숫자를 입력해야 합니다.";
    private final String INPUT_NUMBER_RANGE_ERROR_SENTENCE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final String INPUT_BOARD_ERROR_SENTENCE = "[ERROR] 칸이 잘못 입력되었습니다.";
    private final String INPUT_RETRY_ERROR_SENTENCE = "[ERROR] 잘못된 문자가 입력되었습니다. 재시도: R, 종료: Q";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String bridgeSize) {
        int size = parseInt(bridgeSize);
        validateNumberRange(size);
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String board) {
        validateBoard(board);
        return board;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String retry) {
        validateRetry(retry);
        return retry;
    }

    private int parseInt(String bridgeSize) {
        try {
            return Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR_SENTENCE);
        }
    }

    private void validateNumberRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(INPUT_NUMBER_RANGE_ERROR_SENTENCE);
        }
    }

    private void validateBoard(String board) {
        if (!board.equals("U") && !board.equals("D")) {
            throw new IllegalArgumentException(INPUT_BOARD_ERROR_SENTENCE);
        }
    }

    private void validateRetry(String retry) {
        if (!retry.equals("R") && !retry.equals("Q")) {
            throw new IllegalArgumentException(INPUT_RETRY_ERROR_SENTENCE);
        }
    }

    public String input() {
        return Console.readLine();
    }
}
