package bridge.constant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameStatusTest {

    GameStatus continueStatus;
    GameStatus fail;
    GameStatus success;

    @BeforeEach
    void setUp() {
        continueStatus = GameStatus.CONTINUE;
        fail = GameStatus.FAIL;
        success = GameStatus.SUCCESS;
    }

    @DisplayName("GameStatus isContinue 메소드 검증")
    @Test
    void isContinue() {
        assertThat(continueStatus.isContinue()).isTrue();
    }

    @DisplayName("GameStatus isFail 메소드 검증")
    @Test
    void isFail() {
        assertThat(fail.isFail()).isTrue();
    }

    @DisplayName("GameStatus isSuccess 메소드 검증")
    @Test
    void isSuccess() {
        assertThat(success.isSuccess()).isTrue();
    }

    @DisplayName("GameStatus가 가지고 있는 필드 값 검증")
    @Test
    void getMessage() {
        assertThat(continueStatus.getMessage()).isEqualTo("계속");
        assertThat(fail.getMessage()).isEqualTo("실패");
        assertThat(success.getMessage()).isEqualTo("성공");
    }
}
