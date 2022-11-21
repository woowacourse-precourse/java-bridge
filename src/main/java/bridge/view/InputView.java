package bridge.view;

import bridge.util.ExceptionHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static int readBridgeSize() {
        OutputView.printInputBridgeSize();
        String input = readLine();
        ExceptionHandler.checkBridgeSize(input);
        return Integer.parseInt(input);
    }

    public static String readChoice() {
        OutputView.printInputMoving();
        String input = readLine();
        ExceptionHandler.checkMoving(input);
        return input;
    }

    public static String readRetryCommand() {
        OutputView.printInputRetryCommand();
        String input = readLine();
        ExceptionHandler.checkRetryCommand(input);
        return input;
    }
}
