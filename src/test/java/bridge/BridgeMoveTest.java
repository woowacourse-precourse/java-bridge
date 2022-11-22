package bridge;

import bridge.domain.BridgeMove;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMoveTest {

    @DisplayName("플레이어가 이동할 칸 입력시 U 또는 D 값이 아니라면 예외처리한다.")
    @Test
    void bridgeMoveByNotUorD() {
        Assertions.assertThatThrownBy(() -> new BridgeMove("1")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BridgeMove("u")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BridgeMove("hello world")).isInstanceOf(IllegalArgumentException.class);
    }
}
