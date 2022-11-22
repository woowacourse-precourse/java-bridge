package bridge.ui;

import java.util.List;

import static bridge.Constants.*;
import static bridge.message.ExceptionMessage.*;

public class Validate {

    private static final List<String> DIRECTIONS = List.of(UP, DOWN);
    private static final List<String> COMMANDS = List.of(RETRY, QUIT);

    //숫자 이외의 문자가 입력되면 예외가 발생한다.
    public static void digitTypeValidate(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException(TYPE_EXCEPTION);
        }
    }

    private static boolean isDigit(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    //입력받은 숫자가 3 이상 20 이하의 숫자가 아니라면 예외가 발생한다.
    public static void numberRangeValidate(int number) {
        if (!(MIN_RANGE <= number && number <= MAX_RANGE)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION);
        }
    }

    //U(위 칸), D(아래 칸) 이외의 문자가 입력되면 예외가 발생한다.
    public static void directionValidate(String direction) {
        if (!DIRECTIONS.contains(direction)) {
            throw new IllegalArgumentException(DIRECTION_EXCEPTION);
        }
    }

    //R(재시작), Q(종료) 이외의 문자가 입력되면 예외가 발생한다.
    public static void commandValidate(String command) {
        if (!COMMANDS.contains(command)) {
            throw new IllegalArgumentException(COMMAND_EXCEPTION);
        }
    }
}
