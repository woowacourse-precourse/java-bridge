package exception;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest {

    private static final String ERROR = "[ERROR]";

    @ValueSource(strings = {"1", "21"})
    @ParameterizedTest
    void 다리_길이_검증_테스트(String input) {
        assertThatThrownBy(() -> Exception.bridgeLengthValidation(input))
                .hasMessageContaining(ERROR + " 다리 길이는 3부터 20 사이의 숫자여야 합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"input", "F", "A"})
    @ParameterizedTest
    void 사용자_움직임_입력_검증_테스트(String input) {
        assertThatThrownBy(() -> Exception.readMoveValidation(input))
                .hasMessageContaining(ERROR + " U 또는 D 를 입력해 주세요.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"inputTest", "K", "Z"})
    @ParameterizedTest
    void 사용자_명령어_입력_검증_테스트(String input) {
        assertThatThrownBy(() -> Exception.readGameCommandValidation(input))
                .hasMessageContaining(ERROR + " R 또는 Q 를 입력해 주세요.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}