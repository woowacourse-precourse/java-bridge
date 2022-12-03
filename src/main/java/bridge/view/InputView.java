package bridge.view;

import bridge.validation.Validation;
import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

import static bridge.utils.constant.Constant.*;
import static bridge.utils.constant.ExceptionPhrase.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final Validation validation;

    public InputView(Validation validation) {
        this.validation = validation;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();
        int length = bridgeSizeIsNumeric(size);

        validation.bridgeSizeIsInRange(length);

        return length;
    }

    public int bridgeSizeIsNumeric(String size) {
        int length;
        try {
            length = Integer.parseInt(size);
        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_NUMBER.getPhrase());
        }
        return length;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        validation.moveIsUOrD(move);

        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String quit =  Console.readLine();

        validation.quitOrRestart(quit);
        return quit;
    }
}
