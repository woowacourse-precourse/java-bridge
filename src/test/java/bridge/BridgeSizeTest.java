package bridge;

import bridge.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class BridgeSizeTest {

    @DisplayName("다리 길이 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2", "21"})
    void createBridgeSizeError(String size) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> BridgeSize.of(size))
                .withMessage(ErrorMessage.INVALID_BRIDGE_SIZE_RANGE);
    }
}
