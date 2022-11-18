package bridge.view;

import bridge.ExceptionString;
import bridge.exception.InputException;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static InputException inputException = new InputException();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            String inputSize = readLine();
            inputException.sizeException(inputSize);
            return Integer.parseInt(inputSize);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionString.NOTNULL.getPrint());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            String move = readLine();
            inputException.moveException(move);
            return move;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionString.NOTNULL.getPrint());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            String retry = readLine();
            inputException.retryException(retry);
            return retry;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionString.NOTNULL.getPrint());
        }
    }
}
