package bridge.Utils.Validator;

import java.util.Objects;

public class GameCommandValidator {
    static final String UPPER_CASE_PATTERN = "^[A-Z]*$";
    static final String ERROR_NOT_UPPER_CASE = "[ERROR] 입력 형식이 맞지 않습니다.(대문자)";
    static final String ERROR_NOT_RETRY_QUIT = "[ERROR] 입력 형식이 맞지 않습니다.(R or Q)";
    static final String RETRY = "R";
    static final String QUIT = "Q";
    static final String INIT_STRING = "A";


    public static String commandValid(String input) {
        try {
            commandTypeValid(input);
            commandFormValid(input);
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
    private static void commandTypeValid(String input) {
        if (!input.matches(UPPER_CASE_PATTERN)) {
            System.out.println(ERROR_NOT_UPPER_CASE);
            throw new IllegalArgumentException();
        }
    }


    /**
     * U나 D를 입력하지 않았을 때 예외발생
     *
     * @param input 이동할 칸
     */
    private static void commandFormValid(String input) {
        if (!isRetryQuit(input)) {
            System.out.println(ERROR_NOT_RETRY_QUIT);
            throw new IllegalArgumentException();
        }
    }


    private static boolean isRetryQuit(String input) {
        return ((Objects.equals(input, RETRY)) || (Objects.equals(input, QUIT)));
    }
}
