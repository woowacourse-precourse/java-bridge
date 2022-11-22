package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.exception.InputException.isValidBridgeSize;
import static bridge.exception.InputException.isValidMovementDirection;
import static bridge.exception.InputException.isValidRestartOrQuitCommand;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            OutputView.printInputBridgeSize();
            String bridgeSize = Console.readLine();
            isValidBridgeSize(bridgeSize);
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        try {
            OutputView.printSelectMovementDirection();
            String movementDirection = Console.readLine();
            isValidMovementDirection(movementDirection);
            return movementDirection;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        try {
            OutputView.printInputRestartOrQuitCommand();
            String command = Console.readLine();
            isValidRestartOrQuitCommand(command);
            return command;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
