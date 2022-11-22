package bridge;

import bridge.data.Error;
import bridge.presentation.ExceptionHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionHandlerTest {

    @DisplayName("정상적으로 다리 길이를 입력하면 예외가 발생하지 않는다.")
    @Test
    void normalBridgeSizeInputTest() {
        String inputString = "12";
        int inputInt = 12;

        ExceptionHandler.checkNullInput(inputString);
        ExceptionHandler.checkIsNumber(inputString);
        ExceptionHandler.checkOutOfRange(inputInt);
    }

    @DisplayName("입력값이 없다면 예외를 발생시킨다.")
    @Test
    void nullInputTest() {
        String input = "";
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkNullInput(input));

        assertEquals(exception.getMessage(), Error.NULL_INPUT.getMessage());
    }

    @DisplayName("입력값이 숫자가 아니라면 예외를 발생시킨다.")
    @Test
    void isNumberTest() {
        String input = "j";
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkIsNumber(input));

        assertEquals(exception.getMessage(), Error.NOT_NUMBER.getMessage());
    }

    @DisplayName("입력값의 범위가 3~20이 아니라면 예외를 발생시킨다.")
    @Test
    void outOfRangeTest() {
        int input = 23;

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkOutOfRange(input));

        assertEquals(exception.getMessage(), Error.OUT_OF_RANGE.getMessage());
    }

    @DisplayName("이동을 위한 입력값이 정상이라면 예외가 발생하지 않는다.")
    @Test
    void normalMoveInputTest() {
        String input = "U";

        ExceptionHandler.checkNullInput(input);
        ExceptionHandler.checkIsCharacter(input);
        ExceptionHandler.checkInvalidMove(input);
    }

    @DisplayName("입력값이 1자리 문자가 아니라면 예외를 발생시킨다.")
    @Test
    void isCharacterTest() {
        String input = "RQ";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkIsCharacter(input));

        assertEquals(exception.getMessage(), Error.NOT_CHARACTER.getMessage());
    }

    @DisplayName("이동을 위한 입력값이 U 또는 D가 아니라면 예외를 발생시킨다.")
    @Test
    void invalidMoveTest() {
        String input = "R";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkInvalidMove(input));

        assertEquals(exception.getMessage(), Error.INVALID_MOVE.getMessage());
    }

    @DisplayName("재시작 또는 종료를 위한 입력값이 정상이라면 예외가 발생하지 않는다.")
    @Test
    void normalRetryCommandInputTest() {
        String input = "R";

        ExceptionHandler.checkNullInput(input);
        ExceptionHandler.checkIsCharacter(input);
        ExceptionHandler.checkInvalidRetryCommand(input);
    }

    @DisplayName("재시작 또는 종료를 위한 입력값이 R 또는 Q가 아니라면 예외를 발생시킨다.")
    @Test
    void invalidRetryCommandTest() {
        String input = "E";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> ExceptionHandler.checkInvalidRetryCommand(input));

        assertEquals(exception.getMessage(), Error.INVALID_RETRY_COMMAND.getMessage());
    }
}
