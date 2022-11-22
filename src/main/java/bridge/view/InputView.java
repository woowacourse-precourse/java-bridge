package bridge.view;

import static camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int LOWER_BOUND_INCLUDE = 3;
    private static final int UPPER_BOUND_INCLUDE = 20;

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            int size = Integer.parseInt(readLine());
            validateSize(size);
            return size;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이에 대한 입력이 잘못되었습니다.");
        }
    }

    /**
     * 다리의 길이에 대한 예외처리를 하는 메서드
     * @param size 다리의 길이
     */
    private static void validateSize(int size) {
        if (size < LOWER_BOUND_INCLUDE || size > UPPER_BOUND_INCLUDE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String moving = readLine();

        validateMoving(moving);

        return moving;
    }

    /**
     * 건너기 옵션에 대한 예외처리를 하는 메서드
     * @param moving U 또는 D
     */
    private static void validateMoving(String moving) {
        if (!(moving.equals("D") || moving.equals("U")))
            throw new IllegalArgumentException("[ERROR] 이동할 칸에 대한 입력이 잘못되었습니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        String command = readLine();

        validateCommand(command);

        return command;
    }

    /**
     * 재시작 옵션에 대한 예외처리를 하는 메서드
     * @param command R 또는 Q
     */
    private static void validateCommand(String command) {
        if (!(command.equals("R") || command.equals("Q")))
            throw new IllegalArgumentException("[ERROR] 재시작 옵션 대한 입력이 잘못되었습니다.");
    }
}
