package bridge;

import java.util.NoSuchElementException;

public class CustomException {
    public static final String ERROR_HEAD = "[ERROR] ";
    public static final String NOT_NULL = "NULL 불가.";
    public static final String NOT_BLANK = "Blank 불가.";
    public static final String NOT_NUMBER = "숫자가 아닙니다.";
    public static final String NOT_START_ZERO = "숫자는 0으로 시작 X";
    public static final String OUT_OF_RANGE = "범위 초과";
    public static final String OUT_OF_COMMAND_RANGE = "명령의 길이가 다릅니다.";
    public static final String NOT_MOVING_COMMAND = "유효하지 않은 이동 명령";
    public static final String NOT_QUIT_RETRY = "유효하지 않은 게임 명령입니다.";

    public static void InputNotNullException() {
        throw new IllegalArgumentException(ERROR_HEAD + NOT_NULL);
    }
    public static void NotBlankException(){
        throw new IllegalArgumentException(ERROR_HEAD + NOT_BLANK);
    }
    public static void NotNumberException(){
        throw new NumberFormatException(ERROR_HEAD+NOT_NUMBER);
    }
    public static void StartWithZeroException(){
        throw new NumberFormatException(ERROR_HEAD+NOT_START_ZERO);
    }
    public static void NotNumberRangeException(){
        throw new NumberFormatException(ERROR_HEAD + OUT_OF_RANGE);
    }
    public static void CommandLengthException(){
        throw new NoSuchElementException(ERROR_HEAD+OUT_OF_COMMAND_RANGE);
    }
    public static void NoSuchCommandException(){
        throw new NoSuchElementException(ERROR_HEAD+NOT_MOVING_COMMAND);
    }
    public static void NoSuchMovingException(){
        throw new NoSuchElementException(ERROR_HEAD+NOT_QUIT_RETRY);
    }
}
