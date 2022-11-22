package bridge;

import bridge.domain.Retry;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryTest {

    @DisplayName("게임 재시작 여부 입력시 R 또는 Q 값이 아니라면 예외처리한다.")
    @Test
    void bridgeMoveByNotUorD() {
        Assertions.assertThatThrownBy(() -> new Retry("1")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Retry("r")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Retry("q")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Retry("hello")).isInstanceOf(IllegalArgumentException.class);
    }
}
