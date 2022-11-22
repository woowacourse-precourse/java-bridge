package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int readBridgeSize() {
        String input = Console.readLine();
        int size = InputValidator.changeInputToInt(input);
        InputValidator.validateBridgeSize(size);
        return size;
    }

    public static String readMoving() {
        String input = Console.readLine();
        InputValidator.validateMovementInput(input);
        return input;
    }

    public static String readGameCommand() {
        String input = Console.readLine();
        InputValidator.validateRestartInput(input);
        return input;
    }
}
