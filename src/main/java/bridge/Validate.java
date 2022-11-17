package bridge;

import bridge.message.ExceptionMessage;

import static bridge.message.ExceptionMessage.*;
import static java.lang.Character.*;

public class Validate {

    //숫자 이외의 문자가 입력되면 예외가 발생한다.
    public static void digitTypeValidate(String input) {
        for (char ch : input.toCharArray()) {
            if (!isDigit(ch)) {
                throw new IllegalArgumentException(TYPE_EXCEPTION);
            }
        }
    }

    //입력받은 숫자가 3 이상 20 이하의 숫자가 아니라면 예외가 발생한다.
    public static void numberRangeValidate(int number) {
        if (!(3 <= number && number <= 20)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }
}
