package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameCommandTest {
    @DisplayName("게임 재시작(R)/종료(Q) 이외의 입력시 예외가 발생한다.")
    @Test
    void createCommandByUnValid() {
        assertThatThrownBy(() -> new GameCommand("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
