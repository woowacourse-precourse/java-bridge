package bridge.view;

import bridge.util.ExceptionHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int readBridgeSize() {
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
