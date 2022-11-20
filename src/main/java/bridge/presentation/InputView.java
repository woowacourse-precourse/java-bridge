package bridge.presentation;

import bridge.ExceptionHandler;
import bridge.data.Error;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class InputView {

    public int readBridgeSize() {
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }

        ExceptionHandler.checkNullInput(input);
        ExceptionHandler.checkIsNumber(input);

        int bridgeSize = Integer.parseInt(input);
        ExceptionHandler.checkOutOfRange(bridgeSize);

        return bridgeSize;
    }

    public String readMoving() {
        String move;
        try {
            move = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }

        ExceptionHandler.checkNullInput(move);
        ExceptionHandler.checkIsCharacter(move);
        ExceptionHandler.checkInvalidMove(move);

        return move;
    }

    public String readGameCommand() throws IllegalArgumentException {
        String retryCommand;
        try {
            retryCommand = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(Error.NULL_INPUT.getMessage());
        }

        ExceptionHandler.checkNullInput(retryCommand);
        ExceptionHandler.checkIsCharacter(retryCommand);
        ExceptionHandler.checkInvalidRetryCommand(retryCommand);

        return retryCommand;
    }
}