package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static bridge.domain.GameStatus.*;
import static org.assertj.core.api.Assertions.*;

class GameStatusTest {

    @DisplayName("게임 종료 시 상태가 CLEAR면 성공, QUIT면 실패를 반환한다.")
    @Test
    public void decideGameResultTest() {
        assertThat(decideGameResult(CLEAR)).isEqualTo("성공");
        assertThat(decideGameResult(QUIT)).isEqualTo("실패");
    }

    @DisplayName("게임 종료 시 상태가 CLEAR, QUIT가 아닌 경우 예외가 발생한다.")
    @EnumSource(value = GameStatus.class , names = {"PLAYING", "DEATH", "RETRY"})
    @ParameterizedTest
    public void decideGameResultThrowExceptionTest(GameStatus gameStatus) {
        assertThatThrownBy(() -> decideGameResult(gameStatus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}