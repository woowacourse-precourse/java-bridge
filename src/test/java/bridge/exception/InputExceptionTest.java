package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class InputExceptionTest {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";

    void exceptionTest(InputException inputException, String input) {
        assertThatThrownBy(() -> {
            inputException.exception(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("input이 null일 때 예외처리하는 기능 테스트")
    void test_inputNullException() {
        String input = "";

        InputException inputException = new InputException() {
            @Override
            public void exception(String input) {
                InputException.super.exception(input);
            }
        };
    }

    @Test
    @DisplayName("input이 숫자가 아닐 때 예외처리하는 기능 테스트")
    void test_inputNoNumberException() {
        String input = "x";

        InputException inputException = new InputException() {
            @Override
            public void exception(String input) {
                InputException.super.exception(input);
            }
        };
    }

    @Test
    @DisplayName("input의 범위가 맞지 않을 때 예외처리하는 기능 테스트")
    void test_inputNoRangeException() {
        int input = 2;

        InputException inputException = new InputException() {
            @Override
            public void exception(int input) {
                InputException.super.exception(input);
            }
        };
    }

    @Test
    @DisplayName("input이 1개의 글자가 아닐 때 예외처리하는 기능 테스트")
    void test_inputNoOneCharException() {
        String input = "he";

        InputException inputException = new InputException() {
            @Override
            public void exception(String input) {
                InputException.super.exception(input);
            }
        };
    }

    @Test
    @DisplayName("input이 유효하지 않은 글자일 때 예외처리하는 기능 테스트")
    void test_inputInvalidCharException() {
        String u = "u";
        String d = "d";
        String q = "q";
        String r = "r";

        InputException inputException = new InputException() {
            @Override
            public void exception(String input, String term1, String term2) {
                InputException.super.exception(u, UP, DOWN);
                InputException.super.exception(d, UP, DOWN);
                InputException.super.exception(q, UP, DOWN);
                InputException.super.exception(r, RESTART, QUIT);
                InputException.super.exception(q, RESTART, QUIT);
                InputException.super.exception(u, RESTART, QUIT);
            }
        };
    }

}
