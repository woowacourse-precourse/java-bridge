package bridge.view;

import bridge.model.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int readBridgeSize() {
        String input = Console.readLine();
        Validator.validateSize(input);
        return Integer.parseInt(input);
    }

    public static String readMoving() {
        String input = Console.readLine();
        Validator.validateMove(input);
        return input;
    }

    public static String readGameCommand() {
        String input = Console.readLine();
        Validator.validateCommand(input);
        return input;
    }
}
