package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.exception.InputException.isValidBridgeSize;
import static bridge.exception.InputException.isValidMovementDirection;
import static bridge.exception.InputException.isValidRestartOrQuitCommand;

public class InputView {
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
