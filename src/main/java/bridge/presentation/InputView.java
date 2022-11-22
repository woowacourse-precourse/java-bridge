package bridge.presentation;

import bridge.data.Error;
import bridge.presentation.ExceptionHandler;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputView {

    public int readBridgeSize() {
        String input = checkNullInput();

        ExceptionHandler.checkNullInput(input);
        ExceptionHandler.checkIsNumber(input);

        int bridgeSize = Integer.parseInt(input);
        ExceptionHandler.checkOutOfRange(bridgeSize);

        return bridgeSize;
    }

    private String checkNullInput() throws IllegalArgumentException {
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }

        return input;
    }

    public String readMoving() {
        String move = checkNullInput();

        ExceptionHandler.checkNullInput(move);
        ExceptionHandler.checkIsCharacter(move);
        ExceptionHandler.checkInvalidMove(move);

        return move;
    }

    public String readGameCommand() throws IllegalArgumentException {
        String retryCommand = checkNullInput();

        ExceptionHandler.checkNullInput(retryCommand);
        ExceptionHandler.checkIsCharacter(retryCommand);
        ExceptionHandler.checkInvalidRetryCommand(retryCommand);

        return retryCommand;
    }
}