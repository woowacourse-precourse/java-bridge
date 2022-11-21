package bridge.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameStatusTest {

    @DisplayName("GameStatus isContinue 메소드 검증")
    @Test
    void isContinue() {
        GameStatus aContinue = GameStatus.CONTINUE;
        assertThat(aContinue.isContinue()).isTrue();
    }
}
