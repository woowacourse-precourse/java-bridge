package bridge.ui;

import static bridge.message.ExceptionMessage.*;
import static java.lang.Character.isDigit;

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

    //U(위 칸), D(아래 칸) 이외의 문자가 입력되면 예외가 발생한다.
    public static void directionValidate(String direction) {
        if (!(direction.equals("U") || direction.equals("D"))) {
            throw new IllegalArgumentException(DIRECTION_EXCEPTION);
        }
    }

    //R(재시작), Q(종료) 이외의 문자가 입력되면 예외가 발생한다.
    public static void commandValidate(String command) {
        if (!(command.equals("R") || command.equals("Q"))) {
            throw new IllegalArgumentException(COMMAND_EXCEPTION);
        }
    }
}
