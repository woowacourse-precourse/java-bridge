package bridge.domain.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.validation.BridgeSize;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {

    @ParameterizedTest(name = "숫자가 아닌 값을 입력하면 예외가 발생한다. 입력: {0}")
    @ValueSource(strings = {"하하", "hoho", " ", "1234a"})
    void validateThisIsNumber(String inputValue) {
        assertThatThrownBy(() -> new BridgeSize(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해 주세요.");
    }

    @ParameterizedTest(name = "다리 길이 범위를 벗어나는 값을 입력하면 예외가 발생한다. 입력: {0}")
    @ValueSource(strings = {"0", "2", "25", "30"})
    void validateBridgeSize(String inputValue) {
        assertThatThrownBy(() -> new BridgeSize(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("다리의 길이는 3 이상 20 이하여야 합니다.");
    }
}