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
    private static final int COMMANDSIZE = 1;
    private static final String SIZE_ERROR = "입력 값이 너무 많습니다.";
    private static final String NUMBER_ERROR = "숫자를 입력해주세요.";
    private static final String RANGE_ERROR = "다리 길이는 3~20 사이의 숫자를 입력해주세요.";
    private static final String UPDOWN_ERROR = "U와 D 중 입력해주세요.";
    private static final String RETRYQUIT_ERROR = "R과 Q 중 입력해주세요.";

    private void sizeValidate(String size) {
        if (!isNumber(size)) {
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
        if (!isRange(size)) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private boolean isRange(String size) {
        int size_I = Integer.parseInt(size);
        if (size_I < MIN_RANGE || size_I > MAX_RANGE) return false;
        return true;
    }

    private boolean isNumber(String size) {
        for (int i = 0; i < size.length(); i++) {
            char c = size.charAt(i);
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();
        sizeValidate(size);
        return Integer.parseInt(size);
    }

    private void moveValidate(String move) {
        if (!isOne(move)) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
        if (!isUpDown(move)) {
            throw new IllegalArgumentException(UPDOWN_ERROR);
        }
    }

    private boolean isOne(String command) {
        if (command.length() > COMMANDSIZE) return false;
        return true;
    }

    private boolean isUpDown(String move) {
        if (!move.equals(UP) && !move.equals(DOWN)) return false;
        return true;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        move = move.toUpperCase();
        moveValidate(move);
        return move;
    }

    private void gameCommandValidate(String command) {
        if (!isOne(command)) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
        if (!isRetryQuit(command)) {
            throw new IllegalArgumentException(RETRYQUIT_ERROR);
        }
    }

    private boolean isRetryQuit(String command) {
        if (!command.equals(RETRY) && !command.equals(QUIT)) return false;
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        command = command.toUpperCase();
        gameCommandValidate(command);
        return command;
    }
}
