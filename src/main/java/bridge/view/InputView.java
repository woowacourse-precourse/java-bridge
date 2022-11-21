package bridge.view;

import bridge.util.ExceptionHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int readBridgeSize() {
        OutputView.printInputBridgeSize();
        while (true) {
            try {
                String input = readLine();
                ExceptionHandler.checkBridgeSize(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException illegalArgumentException) {
                throw illegalArgumentException;
            }
        }
    }

    public static String readChoice() {
        OutputView.printInputMoving();
        while (true) {
            try {
                String input = readLine();
                ExceptionHandler.checkMoving(input);
                return input;
            } catch (IllegalArgumentException illegalArgumentException) {
                throw illegalArgumentException;
            }
        }
    }

    public static String readRetryCommand() {
        OutputView.printInputRetryCommand();
        try {
            String input = readLine();
            ExceptionHandler.checkRetryCommand(input);
            return input;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }
}
