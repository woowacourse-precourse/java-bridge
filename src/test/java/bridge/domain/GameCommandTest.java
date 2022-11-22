package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameCommandTest {
    @DisplayName("게임 재시도 여부 입력 값이 R 혹은 Q가 아닌 경우 예외가 발생한다.")
    @Test
    void checkGameCommandInputForm() {
        assertThatThrownBy(() -> new GameCommand("r"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
