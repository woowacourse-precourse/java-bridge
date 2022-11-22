package bridge.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMoveTest {

    @DisplayName("이동이 U나 D인지 검증 확인")
    @Test
    void getEnum() {
        assertThatThrownBy(() -> BridgeMove.getEnum("A")).isInstanceOf(IllegalArgumentException.class);
    }
}