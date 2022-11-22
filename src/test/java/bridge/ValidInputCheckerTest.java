package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidInputCheckerTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리길이 정수 아닌 수")
    @ValueSource(strings = {"4.0", "3.2", "이상윤"})
    @ParameterizedTest
    void isNotInteger(String input){
        assertThatThrownBy(() -> ValidInputChecker.validateIntAndParseInt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("다리길이 범위 밖")
    @ValueSource(strings = {"2", "21"})
    @ParameterizedTest
    void isOutOfRange(String input){
        assertThatThrownBy(() -> ValidInputChecker.validateBridgeSizeRange(Integer.parseInt(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("U나 D 확인")
    @ValueSource(strings = {"", "u", "d","이상윤"})
    @ParameterizedTest
    void isExactlyUorD(String input){
        assertThatThrownBy(() -> ValidInputChecker.validateUorD(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
