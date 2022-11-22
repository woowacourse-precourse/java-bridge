package bridge.exception;

import org.junit.jupiter.api.Test;

import static bridge.exception.Validator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ValidatorTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 문자_입력_에러() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> isNumber("A"));
        String message = exception.getMessage();
        assertThat(message).contains(ERROR_MESSAGE);
    }

    @Test
    void 실수_입력_에러() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> isNumber("1.2"));
        String message = exception.getMessage();
        assertThat(message).contains(ERROR_MESSAGE);
    }

    @Test
    void NULL_입력_에러() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> isNull(null));
        String message = exception.getMessage();
        assertThat(message).contains(ERROR_MESSAGE);
    }

    @Test
    void 숫자_입력_범위_에러_2() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> inRange(2, 3, 20));
        String message = exception.getMessage();
        assertThat(message).contains(ERROR_MESSAGE);
    }

    @Test
    void 숫자_입력_범위_에러_21() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> inRange(21, 3, 20));
        String message = exception.getMessage();
        assertThat(message).contains(ERROR_MESSAGE);
    }
}
