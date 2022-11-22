package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;


public class InputExceptionTest {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    InputException inputException = new InputException();

    @Test
    void test_inputNullException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputException.inputNullException("");
        });
    }

    @Test
    void test_inputNoNumberException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputException.inputNoNumberException("x");
            inputException.inputNoNumberException(",");
        });
    }

    @Test
    void test_inputNoRangeException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputException.inputNoRangeException(2);
            inputException.inputNoRangeException(22);
        });
    }

    @Test
    void test_inputNoOneCharException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputException.inputNoOneCharException("");
            inputException.inputNoOneCharException("he");
        });
    }

    @Test
    void test_inputInvalidCharException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputException.inputInvalidCharException("u", UP, DOWN);
            inputException.inputInvalidCharException("d", UP, DOWN);
            inputException.inputInvalidCharException("q", UP, DOWN);
            inputException.inputInvalidCharException("r", RESTART, QUIT);
            inputException.inputInvalidCharException("q", RESTART, QUIT);
            inputException.inputInvalidCharException("u", RESTART, QUIT);
        });
    }

}
