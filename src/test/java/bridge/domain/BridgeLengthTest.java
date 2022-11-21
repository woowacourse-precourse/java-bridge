package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    // 숫자가 아닌 문자를 입력할 경우
    // 3 이상 20 이하가 아닌 경우

}
