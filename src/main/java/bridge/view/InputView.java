package bridge.view;

import bridge.view.enums.ExceptionString;
import bridge.exception.InputException;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.*;

public class InputView {
    private static InputException inputException = new InputException();

    public int readBridgeSize() {
        try {
            String inputSize = readLine();
            inputException.sizeException(inputSize);
            return Integer.parseInt(inputSize);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionString.NOTNULL.getPrint());
        } catch (IllegalArgumentException e) {
            return readBridgeSize();
        }
    }

    public String readMoving() {
        try {
            String move = readLine();
            inputException.moveException(move);
            return move;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionString.NOTNULL.getPrint());
        } catch (IllegalArgumentException e) {
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            String retry = readLine();
            inputException.retryException(retry);
            return retry;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionString.NOTNULL.getPrint());
        } catch (IllegalArgumentException e) {
            return readGameCommand();
        }
    }
}
