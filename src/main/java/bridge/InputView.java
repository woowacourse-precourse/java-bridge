package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final Validate validate = new Validate();

    public int readBridgeSize() {
        String input = Console.readLine();
        validate.isBridgeSize(input);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        return null;
    }

    public String readGameCommand() {
        return null;
    }
}
