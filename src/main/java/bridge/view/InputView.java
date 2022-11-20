package bridge.view;

import bridge.util.InputConstant;
import bridge.util.MessageConstant;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    private static final String ZERO = "0";

    public String input() {
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String size) throws IllegalArgumentException {
        validateIsNotEmpty(size);
        validateIsNumber(size);
        return validateIsLengthRange(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String direction) throws IllegalArgumentException {
        validateIsNotEmpty(direction);
        validateDirection(direction);
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String decision) throws IllegalArgumentException {
        validateDecision(decision);
        return decision;
    }

    public void validateIsNotEmpty(String size) {
        if(size.isBlank()) {
            throw new IllegalArgumentException(MessageConstant.ERROR_EMPTY.getValue());
        }
    }

    public void validateIsNumber(String size) {
        String regExp = "^[0-9]*$";
        if(!size.matches(regExp) || String.valueOf(size.charAt(0)).equals(ZERO)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_BRIDGE_LENGTH.getValue());
        }
    }

    public int validateIsLengthRange(String input) {
        int size = Integer.parseInt(input);
        if(size < MIN_LENGTH || size > MAX_LENGTH) {
            throw new IllegalArgumentException(MessageConstant.ERROR_BRIDGE_LENGTH.getValue());
        }
        return size;
    }

    public void validateDirection(String direction) {
        if(!isExistDirection(direction)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_INPUT_DIRECTION.getValue());
        }
    }

    public boolean isExistDirection(String direction) {
        return Arrays.asList(InputConstant.UP.getValue(), InputConstant.DOWN.getValue()).contains(direction);
    }

    public void validateDecision(String decision) {
        if(!decision.equals(InputConstant.RESTART.getValue()) && !decision.equals(InputConstant.QUIT.getValue())) {
            throw new IllegalArgumentException(MessageConstant.ERROR_INPUT_GAME_CONTINUOUS.getValue());
        }
    }
}
