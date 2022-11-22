package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.util.ExceptionHandler;

public class InputView {

    private final OutputView outputView = new OutputView();

    public int readBridgeSize() {
        while (true) {
            String input = readLine();
            try {
                ExceptionHandler.checkBridgeSize(input);
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
                ExceptionHandler.checkMoving(input);
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
                ExceptionHandler.checkRetryCommand(input);
                return input;
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printError(illegalArgumentException);
            }
        }
    }
}
