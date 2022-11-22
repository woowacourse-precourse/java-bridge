package bridge.util.validator;

import static bridge.util.Constants.*;
import static bridge.util.Error.*;

/**
 * 입력 값이 유효한지 확인하는 역할을 한다.
 */
public class InputValidator {

    public static final int BRIDGE_SIZE_LOWER_INCLUSIVE = 3;
    public static final int BRIDGE_SIZE_UPPER_INCLUSIVE = 20;
    public static final String VALID_NUMERIC_FORMAT = "[1-2]?\\d";

    /**
     * 입력 받은 다리의 길이가 유효한지 확인한다.
     */
    public static void bridgeSizeValidate(String input) {
        int number = parseBridgeSize(input);
        if (number < BRIDGE_SIZE_LOWER_INCLUSIVE || number > BRIDGE_SIZE_UPPER_INCLUSIVE) {
            throw new IllegalArgumentException(OUT_OF_RANGE.toString());
        }
    }

    /**
     * 입력 받은 다리의 길이가 숫자로 파싱될 수 있는지 확인한다.
     */
    private static int parseBridgeSize(String input) {
        if (!input.matches(VALID_NUMERIC_FORMAT)) {
            throw new IllegalArgumentException(OUT_OF_RANGE.toString());
        }
        return Integer.parseInt(input);
    }

    /**
     * 입력 받은 이동할 칸이 유효한지 확인한다.
     */
    public static void moveDirectionValidate(String input) {
        if (!(input.equals(UP) || input.equals(DOWN))) {
            throw new IllegalArgumentException(NOT_U_NOR_D.toString());
        }
    }

    /**
     * 입력 받은 재시도 여부가 유효한지 확인한다.
     */
    public static void retryValidate(String input) {
        if (!(input.equals(RETRY) || input.equals(QUIT))) {
            throw new IllegalArgumentException(NOT_R_NOR_Q.toString());
        }
    }
}
