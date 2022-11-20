package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

import static bridge.utils.constant.Constant.*;
import static bridge.utils.constant.ExceptionPhrase.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String size = Console.readLine();
        int length = bridgeSizeIsNumeric(size);

        return bridgeSizeRange(length);
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

    public int bridgeSizeRange(int bridge) {
        if(bridge < 3 || bridge > 20) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_RANGE_IN_THREE_TO_TWENTY.getPhrase());
        }
        return bridge;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        if(!(move.equals(UP.getValue()) || move.equals(DOWN.getValue()))) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_U_OR_D.getPhrase());
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String quit =  Console.readLine();

        if(!(quit.equals(QUIT.getValue()) || quit.equals(RESTART.getValue()))) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_Q_OR_R.getPhrase());
        }
        return quit;
    }
}
