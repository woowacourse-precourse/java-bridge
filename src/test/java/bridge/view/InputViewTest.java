package bridge.view;

import bridge.domain.BridgeSize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "-1", "0", "999999999999"})
    @DisplayName("사용자가 다리길이에 잘못된 값을 입력하면 에러 발생")
    void readBridgeSize(String input) {
        Assertions.assertThatThrownBy(() -> new BridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
