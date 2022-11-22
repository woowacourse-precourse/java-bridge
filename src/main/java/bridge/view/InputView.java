package bridge.view;

import bridge.exception.BridgeRangeException;
import bridge.exception.MoveValueException;
import bridge.exception.RetryValueException;
import bridge.util.IntConverter;

import static camp.nextstep.edu.missionutils.Console.readLine;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final int BRIDGE_LOWER_NUMBER = 3;
    private static final int BRIDGE_UPPER_NUMBER = 20;
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    public int readBridgeSize() {
        try {
            return validateBridgeSize(IntConverter.convert(readLine()));
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }
    }

    private int validateBridgeSize(int size) {
        if ((size < BRIDGE_LOWER_NUMBER) || (size > BRIDGE_UPPER_NUMBER)) {
            throw new BridgeRangeException(BRIDGE_LOWER_NUMBER, BRIDGE_UPPER_NUMBER);
        }
        return size;
    }

    public String readMoving() {
        try {
            return validateMove(readLine());
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return readMoving();
        }
    }

    private String validateMove(String move) {
        if (!(move.equals(UP) || move.equals(DOWN))) {
            throw new MoveValueException(UP, DOWN);
        }
        return move;
    }

    public String readGameCommand() {
        try {
            return validateRetry(readLine());
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
            return readGameCommand();
        }
    }

    private String validateRetry(String gameCommand) {
        if (!(gameCommand.equals(RETRY) || gameCommand.equals(QUIT))) {
            throw new RetryValueException(RETRY, QUIT);
        }
        return gameCommand;
    }
}
