package bridge.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeValidUtilTest {

    @DisplayName("다리 검증 유틸 다리 길이가 2이면 예외 발생")
    @Test
    void validateMinimumSize() {
        assertThatThrownBy(() -> BridgeValidUtil.validateSize(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 3이상 20이하 이어야 합니다.");
    }
}