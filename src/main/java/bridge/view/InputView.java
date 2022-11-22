package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.util.ExceptionHandler;

public class InputView {

    private final ExceptionHandler exceptionHandler = new ExceptionHandler();
    private final OutputView outputView = new OutputView();

    public int readBridgeSize() {
        while (true) {
            String input = readLine();
            try {
                exceptionHandler.checkBridgeSize(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException);
            }
        }
    }

    public String readChoice() {
        while (true) {
            String input = readLine();
            try {
                exceptionHandler.checkMoving(input);
                return input;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException);
            }
        }
    }

    public String readRetryCommand() {
        while (true) {
            try {
                String input = readLine();
                exceptionHandler.checkRetryCommand(input);
                return input;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException);
            }
        }
    }
}
