package bridge.view;

import bridge.model.constant.Message;
import bridge.util.ExceptionHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int readBridgeSize() {
        System.out.println(Message.INPUT_BRIDGE_LENGTH);
        while (true) {
            String input = readLine();
            try {
                ExceptionHandler.checkBridgeSize(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printError(illegalArgumentException);
            }
        }
    }

    public static String readChoice() {
        System.out.println(Message.INPUT_MOVING);
        while (true) {
            String input = readLine();
            try {
                ExceptionHandler.checkMoving(input);
                return input;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printError(illegalArgumentException);
            }
        }
    }

    public static String readRetryCommand() {
        System.out.println(Message.INPUT_RETRY_COMMAND);
        while (true) {
            try {
                String input = readLine();
                ExceptionHandler.checkRetryCommand(input);
                return input;
            } catch (IllegalArgumentException illegalArgumentException) {
                OutputView.printError(illegalArgumentException);
            }
        }
    }
}
