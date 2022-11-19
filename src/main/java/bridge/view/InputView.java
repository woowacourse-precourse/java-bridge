package bridge.view;

import bridge.util.IntConverter;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String NO_SUCH_ELEMENT_EXCEPTION_MESSAGE = "[ERROR] 입력값이 비었습니다.";
    private static final String EXCEPTION_MESSAGE_OVER_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String EXCEPTION_MESSAGE_INVALID_MOVE = "[ERROR] 이동 가능 칸은 U 또는 D 만 있습니다.";
    private static final int BRIDGE_LOWER_NUMBER = 3;
    private static final int BRIDGE_UPPER_NUMBER = 20;
    private static final String UP = "U";
    private static final String DOWN = "D";

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
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_OVER_SIZE);
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
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_INVALID_MOVE);
        }
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private static String readLine() {
        try {
            return camp.nextstep.edu.missionutils.Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(NO_SUCH_ELEMENT_EXCEPTION_MESSAGE);
        }
    }
}
