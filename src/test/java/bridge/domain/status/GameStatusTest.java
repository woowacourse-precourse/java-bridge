package bridge.domain.status;

import bridge.exception.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameStatusTest {

    @Test
    @DisplayName("게임 재시작 상태를 확인하는 테스트")
    public void isGameStatusRetryTest() {
        GameStatus gameStatus = GameStatus.RETRY;

        Assertions.assertThat(gameStatus.checkIsRetryStatus(GameStatus.RETRY)).isTrue();
    }

    @Test
    @DisplayName("게임 진행 상태를 확인하는 테스트")
    public void isGameStatusProceedTest() {
        GameStatus gameStatus = GameStatus.PROCEED;

        Assertions.assertThat(gameStatus.checkIsProceedStatus(GameStatus.PROCEED)).isTrue();
    }

    @Test
    @DisplayName("게임 상태를 변환 해주는 테스트")
    public void convertGameStatusTest() {
        GameStatus expectedStatus = GameStatus.QUIT;
        String input = "Q";

        Assertions.assertThat(GameStatus.convertGameStatus(input)).isEqualTo(expectedStatus);
    }

    @Test
    @DisplayName("게임 상태를 변환 해주는 테스트 (예외 발생)")
    public void convertGameStatusExceptionTest() {
        String input = "A";

        Assertions.assertThatThrownBy(() -> GameStatus.convertGameStatus(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(String.valueOf(ExceptionMessage.COMMEND_NOT_FOUND_ERROR));
    }

}
