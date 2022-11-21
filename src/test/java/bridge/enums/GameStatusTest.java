package bridge.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameStatusTest {

    private GameStatus continueStatus;
    private GameStatus fail;
    private GameStatus success;

    @BeforeEach
    void setUp() {
        continueStatus = GameStatus.CONTINUE;
        fail = GameStatus.FAIL;
        success = GameStatus.SUCCESS;
    }

    @DisplayName("isContinue 메소드 검증")
    @Test
    void isContinue() {
        assertThat(continueStatus.isContinue()).isTrue();
    }

    @DisplayName("isFail 메소드 검증")
    @Test
    void isFail() {
        assertThat(fail.isFail()).isTrue();
    }

    @DisplayName("isSuccess 메소드 검증")
    @Test
    void isSuccess() {
        assertThat(success.isSuccess()).isTrue();
    }

    @DisplayName("가지고 있는 필드 값 검증")
    @Test
    void getMessage() {
        assertThat(continueStatus.getMessage()).isEqualTo("계속");
        assertThat(fail.getMessage()).isEqualTo("실패");
        assertThat(success.getMessage()).isEqualTo("성공");
    }
}
