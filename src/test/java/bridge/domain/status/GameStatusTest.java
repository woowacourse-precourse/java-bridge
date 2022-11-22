package bridge.domain.status;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameStatusTest {

    @Test
    @DisplayName("게임 상태를 확인하는 테스트")
    public void isGameStatusTest() {
        GameStatus gameStatus = GameStatus.RETRY;

        Assertions.assertThat(gameStatus.checkGameStatus(GameStatus.RETRY)).isTrue();
    }

}
