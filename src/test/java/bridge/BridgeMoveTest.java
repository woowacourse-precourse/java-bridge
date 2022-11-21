package bridge;

import bridge.domain.bridge.BridgeMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeMoveTest {
    @DisplayName("이동 방향이 U거나 D가 아니면 예외가 발생한다. (다른 문자)")
    @Test
    void createBridgeMoveByOutOfRange() {
        assertThatThrownBy(() -> new BridgeMove("F"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("이동 방향이 U거나 D가 아니면 예외가 발생한다. (숫자)")
    @Test
    void createBridgeMoveByNumber() {
        assertThatThrownBy(() -> new BridgeMove("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
