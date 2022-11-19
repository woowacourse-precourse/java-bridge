package bridge.Utils.Validator;

import java.util.Objects;

public class MovementValidator {

    static final String UPPER_CASE_PATTERN = "^[A-Z]*$";
    static final String ERROR_NOT_UPPER_CASE = "[ERROR] 입력 형식이 맞지 않습니다.(대문자)";
    static final String ERROR_NOT_UP_DOWN = "[ERROR] 입력 형식이 맞지 않습니다.(U or D)";
    static final String UP = "U";
    static final String DOWN = "D";
    static final String INIT_STRING = "A";


    public static String movementValid(String input) {
        try {
            movementTypeValid(input);
            movementFormValid(input);
            return input;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println(e);
            return INIT_STRING;
        }
    }


    /**
     * 대문자인지 검증
     *
     * @param input 이동할 칸을 입력받음
     */
    private static void movementTypeValid(String input) {
        if (!input.matches(UPPER_CASE_PATTERN)) {
            System.out.println(ERROR_NOT_UPPER_CASE);
            throw new IllegalArgumentException();
        }
    }


    /**
     * Q나 R을 입력하지 않았을 때 예외발생
     *
     * @param input 이동할 칸
     */
    private static void movementFormValid(String input) {
        if (!(isUpDown(input))) {
            System.out.println(ERROR_NOT_UP_DOWN);
            throw new IllegalArgumentException();
        }
    }


    private static boolean isUpDown(String input) {
        return ((Objects.equals(input, UP)) || (Objects.equals(input, DOWN)));
    }

}
