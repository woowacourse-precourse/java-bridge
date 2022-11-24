package bridge.view;

import bridge.util.InputConstant;
import bridge.util.MessageConstant;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class InputView {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    private static final String ZERO = "0";

    public String input() {
        return Console.readLine();
    }


    public int readBridgeSize(String size) throws IllegalArgumentException {
        validateIsNotEmpty(size);
        validateIsNumber(size);
        return validateIsLengthRange(size);
    }


    public String readMoving(String direction) throws IllegalArgumentException {
        validateIsNotEmpty(direction);
        validateDirection(direction);
        return direction;
    }


    public String readGameCommand(String decision) throws IllegalArgumentException {
        validateDecision(decision);
        return decision;
    }

    private void validateIsNotEmpty(String size) {
        if(size.isBlank()) {
            throw new IllegalArgumentException(MessageConstant.ERROR_EMPTY.getValue());
        }
    }

    private void validateIsNumber(String size) {
        String regExp = "^[0-9]*$";
        if(!size.matches(regExp) || String.valueOf(size.charAt(0)).equals(ZERO)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_BRIDGE_LENGTH.getValue());
        }
    }

    private int validateIsLengthRange(String input) {
        int size = Integer.parseInt(input);
        if(size < MIN_LENGTH || size > MAX_LENGTH) {
            throw new IllegalArgumentException(MessageConstant.ERROR_BRIDGE_LENGTH.getValue());
        }
        return size;
    }

    private void validateDirection(String direction) {
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
