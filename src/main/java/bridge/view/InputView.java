package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;
    private static final String BRIDGE_SIZE_ERROR_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String WRONG_INPUT_MESSAGE = "잘못된 값을 입력하였습니다.";
    private static final String MOVE_TO_UP = "U";
    private static final String MOVE_TO_DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        int size = Integer.parseInt(Console.readLine());
        if (size < BRIDGE_MIN_SIZE || size > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE);
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String moving = Console.readLine();
        if (!moving.equals(MOVE_TO_UP) && !moving.equals(MOVE_TO_DOWN)) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String command = Console.readLine();
        if (!command.equals(RETRY) && !command.equals(QUIT)) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
        return command;
    }
}
