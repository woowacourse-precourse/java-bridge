package bridge.domain.view;

import bridge.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    InputException inputException = new InputException();

    public int readBridgeLength() {
        String input = Console.readLine();
        inputException.inputBridgeLengthException(input);
        return Integer.parseInt(input);
    }

    public String readMoving() {
        String input = Console.readLine();
        inputException.inputMoveException(input);
        return input;
    }

    public String readGameCommand() {
        String input = Console.readLine();
        inputException.inputRestartException(input);
        return input;
    }
}
