package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public int readBridgeSize() {
        String input = Console.readLine();
        inputValidator.checkBridgeInput(input);

        return Integer.parseInt(input);
    }

    public String readMoving() {
        String input = Console.readLine();
        inputValidator.checkMovement(input);

        return input;
    }

    public String readGameCommand() {
        String input = Console.readLine();
        inputValidator.checkRetryInput(input);

        return input;
    }
}
