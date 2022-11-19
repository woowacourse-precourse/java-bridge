package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RetryCommandTest {

    @DisplayName("R, Q 이외 값을 입력한 경우 예외 발생")
    @ParameterizedTest
    @CsvSource({
            "RETRY", "QUIT", "re", "QUit", "U", "D"
    })
    void ThrowExceptionWHenInputIsNotRorD(String input) {
        assertThatThrownBy(() -> RetryCommand.nameOf(input)).isInstanceOf(IllegalArgumentException.class);
    }
}