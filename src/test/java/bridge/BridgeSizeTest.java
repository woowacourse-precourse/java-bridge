package bridge;

import static bridge.config.ExceptionMessage.ERROR;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.size.BridgeSize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeSizeTest {

    @DisplayName("길이를 숫자를 입력하지 않으면 예외가 발생")
    @ValueSource(strings = {"일", "2이", "23!", "1@"})
    @ParameterizedTest
    void inputNotNumber(String input) {
        assertThatThrownBy(()-> new BridgeSize(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ERROR);
    }
}
