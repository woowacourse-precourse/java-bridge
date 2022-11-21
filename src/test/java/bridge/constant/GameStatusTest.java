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

    @DisplayName("GameStatus isFail 메소드 검증")
    @Test
    void isFail() {
        GameStatus fail = GameStatus.FAIL;
        assertThat(fail.isFail()).isTrue();
    }

    @DisplayName("GameStatus isSuccess 메소드 검증")
    @Test
    void isSuccess() {
        GameStatus success = GameStatus.SUCCESS;
        assertThat(success.isSuccess()).isTrue();
    }
}
