package bridge;

import java.util.regex.Pattern;

public class Validator {
    static final int MIN_SIZE = 3;
    static final int MAX_SIZE = 20;

    private Validator() {}

    /**
    * 입력값이 숫자로 변환이 된다면 변환한 값을 반환하고, 그렇지 않으면 예외를 반환한다.
    * @return int
    * */
    public static int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
        }
    }

    /**
     * 입력값이 3 ~ 20 사이가 아니라면 예외를 반환한다.
     * */
    public static void isInRange(int number) {
        if (MIN_SIZE > number || number > MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
