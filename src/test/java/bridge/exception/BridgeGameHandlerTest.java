package bridge.exception;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameHandlerTest {
    @DisplayName("이동 기능 - space 파라미터 값이 3~20 사이가 아닐 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 21})
    void handleSpaceOutOfRangeExceptionTest(int space) {
        assertThatThrownBy(() -> {
            BridgeGameExceptionHandler.handleSpaceOutOfRangeException(space);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("[ERROR]");
    }
}
