package bridge.view;
import bridge.exception.BridgeGameError;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return inputBridgeSize();
    }

    private static int inputBridgeSize() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(BridgeGameError.BRIDGE_SIZE_NOT_NUMBER.getErrorMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */

    public String readMoving() {
        return inputMoving();
    }

    private static String inputMoving() {
        try {
            return String.valueOf(Console.readLine());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(BridgeGameError.INVALID_TYPE_MOVE_COMMAND.getErrorMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return inputGameCommand();
    }

    private static String inputGameCommand() {
        try {
            return String.valueOf(Console.readLine());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(BridgeGameError.INVALID_TYPE_GAME_COMMAND.getErrorMessage());
        }
    }
}
