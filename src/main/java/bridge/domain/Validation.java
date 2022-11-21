package bridge.domain;

import bridge.Instances.InputValidationType;

import java.util.List;

import static bridge.Instances.InputValidationType.*;
import static bridge.Instances.Setting.*;

public class Validation {
    static final String ERROR = "[ERROR] ";
    static final String ERROR_NOT_A_NUMBER = ERROR + "숫자가 아닙니다.";
    static final String ERROR_WRONG_VALUE = ERROR + "잘못된 입력입니다.";
    static final String ERROR_OUT_OF_RANGE = ERROR + " 숫자가 3에서 20 사이의 값이 아닙니다.";
    static final String ERROR_WRONG_SIZE = ERROR + "리스트의 크기가 잘못되었습니다.";

    public static void isNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_A_NUMBER);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_WRONG_VALUE);
        }
    }

    public static void inRange(String input) throws IllegalArgumentException {
        int number = Integer.parseInt(input);
        if ((number < BRIDGE_START_RANGE) || (number > BRIDGE_END_RANGE)) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    public static void isUorD(String input) throws IllegalArgumentException {
        if (!(input.equals(MOVING_UP)) && !(input.equals(MOVING_DOWN))) {
            throw new IllegalArgumentException(ERROR_WRONG_VALUE);
        }
    }

    public static void isRorQ(String input) throws IllegalArgumentException {
        if (!(input.equals(COMMAND_RETRY)) && !(input.equals(COMMAND_QUIT))) {
            throw new IllegalArgumentException(ERROR_WRONG_VALUE);
        }
    }

    public static void validateInput(InputValidationType type, String input) {
        if (type.equals(BRIDGE_SIZE)) {
            isNumber(input);
            inRange(input);
        } else if (type.equals(MOVING)) {
            isUorD(input);
        } else if (type.equals(GAME_COMMAND)) {
            isRorQ(input);
        }
    }

    public static <T> void correctSize(int size, List<T> list) {
        if (list.size() != size) {
            throw new RuntimeException(ERROR_WRONG_SIZE);
        }
    }
}
