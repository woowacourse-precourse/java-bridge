package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeLengthTest {
    @DisplayName("아무것도 입력하지 않은 경우")
    @Test
    void validateNullInput() {
        String inputLength = "";
        assertThatThrownBy(() -> BridgeLength.createBridgeLength(inputLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다시 입력해주세요.");
    }

    @DisplayName("숫자가 아닌 문자를 입력할 경우")
    @ValueSource(strings = {"U", "-", "-3"})
    @ParameterizedTest
    void validateNotNumeric(String inputLength) {
        assertThatThrownBy(() -> BridgeLength.createBridgeLength(inputLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력해야 합니다.");
    }

    @DisplayName("3 이상 20 이하가 아닌 경우")
    @ValueSource(strings = {"0", "2", "21"})
    @ParameterizedTest
    void validateInRange(String inputLength) {
        assertThatThrownBy(() -> BridgeLength.createBridgeLength(inputLength))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}
