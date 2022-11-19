package bridge.service.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("[예외처리] 게임 재시작 명령")
class RetryExceptionTest {

    @DisplayName("명령이 Q R 중 하나가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"A", "B", "C", "E", "E", "F", "U", "YES", "NO"})
    @ParameterizedTest
    void checkRetryIsCorrectFormatTest(String command) {
        assertThatThrownBy(() -> RetryException.checkRetryIsCorrectFormat(command))
                .isInstanceOf(IllegalArgumentException.class);
    }
}