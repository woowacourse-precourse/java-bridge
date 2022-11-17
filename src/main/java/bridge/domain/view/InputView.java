package bridge.domain.view;

import bridge.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    InputException inputException = new InputException();

    public int readBridgeSize() {
        String input = Console.readLine();
        inputException.inputBridgeLengthException(input);
        return Integer.parseInt(input);
    }

    public char readMoving() {
        String input = Console.readLine();
        inputException.inputMoveException(input);
        return input.charAt(0);
    }

    public char readGameCommand() {
        String input = Console.readLine();
        inputException.inputRestartException(input);
        return input.charAt(0);
    }
}
