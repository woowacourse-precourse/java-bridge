package bridge.io;

import bridge.domain.game.BridgeGame;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int LOWER_BRIDGE_SIZE_INCLUSIVE = 3;
    private static final int UPPER_BRIDGE_SIZE_INCLUSIVE = 20;
    private static final String RETRY_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();
        try {
            validateBridgeSize(bridgeSize);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    private static void validateBridgeSize(String bridgeSize)
            throws IllegalArgumentException {
        int size;
        try {
            size = Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
        if (!isInRange(size))
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    private static boolean isInRange(int size) {
        return LOWER_BRIDGE_SIZE_INCLUSIVE <= size
                && size <= UPPER_BRIDGE_SIZE_INCLUSIVE;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String direction = Console.readLine();
        try {
            validateDirection(direction);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return direction;
    }

    private static void validateDirection(String direction)
            throws IllegalArgumentException {
        if (!isUpOrDown(direction))
            throw new IllegalArgumentException("[ERROR] U 혹은 D만 입력할 수 있습니다.");
    }

    private static boolean isUpOrDown(String direction) {
        return direction.equals(BridgeGame.UP_DIRECTION)
                || direction.equals(BridgeGame.DOWN_DIRECTION);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = Console.readLine();
        try {
            validateCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return command;
    }

    private static void validateCommand(String command)
            throws IllegalArgumentException {
        if (!isProperCommand(command))
            throw new IllegalArgumentException("[ERROR] R 혹은 Q만 입력할 수 있습니다.");
    }

    private static boolean isProperCommand(String command) {
        return command.equals(RETRY_COMMAND) || command.equals(QUIT_COMMAND);
    }
}
