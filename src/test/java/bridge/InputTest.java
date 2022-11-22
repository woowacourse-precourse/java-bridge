package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {

    @DisplayName("다리 크기 범위 밖의 입력에 대한 예외 처리")
    @ValueSource(strings = {"99999999999", "-1", "0", "-1000000000000000000"})
    @ParameterizedTest
    void invalidBridgeSize(String bridgeSize) {
        assertThatThrownBy(() -> Validator.validateBridgeSize(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
