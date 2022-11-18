package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private static final String SIZE_ERROR = "다리 길이는 " + MIN_SIZE + "부터 " + MAX_SIZE + "까지 가능합니다.";
    private static final String MOVING_ERROR = UP + "(위) 또는 " + DOWN + "(아래)로만 이동이 가능합니다.";
    private static final String COMMAND_ERROR = RESTART + "(재시도) 또는 " + QUIT + "(종료)만 선택 가능합니다.";
    private static final String NUMBER_FORMAT_ERROR = "숫자가 아닙니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size = convert(input());
        return checkSize(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return checkMoving(input());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return checkCommand(input());
    }

    private String checkCommand(String command) {
        if (isWrongCommand(command)) {
            throw new IllegalArgumentException(COMMAND_ERROR);
        }
        return command;
    }

    private boolean isWrongCommand(String command) {
        return !(command.equals(RESTART) || command.equals(QUIT));
    }

    private String checkMoving(String moving) {
        if (isWrongMoving(moving)) {
            throw new IllegalArgumentException(MOVING_ERROR);
        }
        return moving;
    }

    private boolean isWrongMoving(String moving) {
        return !(moving.equals(UP) || moving.equals(DOWN));
    }

    private int checkSize(int size) {
        if (size < MIN_SIZE || MAX_SIZE < size) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
        return size;
    }

    private int convert(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private String input() {
        return Console.readLine();
    }
}
