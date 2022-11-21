package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.security.CodeSigner;

public class InputView {

    private final Validate validate = new Validate();

    public int readBridgeSize() {
        String input = Console.readLine();
        validate.isBridgeSize(input);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        String input = Console.readLine();
        validate.isMoving(input);
        return input;
    }

    public String readGameCommand() {
        return null;
    }
}
