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

    private void sizeValidate(String size) {
        if (!isNumber(size)) {
            throw new IllegalArgumentException();
        }
        if (!isRange(size)) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
        if (!isUpDown(move)) {
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();
        }
        if (!isRetryQuit(command)) {
            throw new IllegalArgumentException();
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
