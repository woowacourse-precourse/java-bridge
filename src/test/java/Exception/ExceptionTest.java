package Exception;

import Util.Exception;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

    Exception exception = new Exception();

    @Test
    public void throwIllegalArgumentExceptionError() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            exception.throwIllegalArgumentExceptionError("ERROR");
        });
    }

    @Test
    void validateIfInputIsNumberTest() {
        try {
            exception.validateIfInputIsNumber("!");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 잘못된 입력입니다.", e.getMessage());
        }
    }

    @Test
    void validateInputNumberRangeTest() {
        try {
            exception.validateInputNumberRange("21");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 숫자의 범위는 3이상 20이하여야 합니다.", e.getMessage());
        }
    }

    @Test
    void validateMovingInputTest() {
        try {
            exception.validateIfInputIsNumber("K");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 잘못된 입력입니다.", e.getMessage());
        }
    }

    @Test
    void validateRetryInputTest() {
        try{
            exception.validateRetryInput("S");
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals("[ERROR] 잘못된 입력입니다.", e.getMessage());
        }
    }
}
